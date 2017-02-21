package test.codepath.aaneja.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import test.codepath.aaneja.simpletodo.adapters.ToDoItemAdapter;
import test.codepath.aaneja.simpletodo.models.ToDoItem;

public class MainActivity extends AppCompatActivity {

    ListView lvItems;
    private ArrayList<ToDoItem> items;
    private ToDoItemAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById(R.id.lvItems);

        ReadItems();
        itemsAdapter = new ToDoItemAdapter(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        SetupListViewListener();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == EditItemActivity.EDIT_REQUEST_CODE) {
            ToDoItem todoUpdatedValue = data.getParcelableExtra(EditItemActivity.ToDoItem);
            boolean AddItemRequest = data.getBooleanExtra(EditItemActivity.AddItemRequest,false);

            if(AddItemRequest)  {
                items.add(todoUpdatedValue);
            }
            else {
                int pos = data.getExtras().getInt(EditItemActivity.Position, 0);
                items.set(pos,todoUpdatedValue);
            }
            
            itemsAdapter.notifyDataSetChanged();
            //WriteItems();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void SetupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id){
                    items.remove(pos);
                    itemsAdapter.notifyDataSetChanged();
                    WriteItems();
                    return true;
                }
        });
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View item, int pos, long id){
                Intent callEdit = new Intent(MainActivity.this, EditItemActivity.class);
                callEdit.putExtra(EditItemActivity.AddItemRequest, false);
                callEdit.putExtra(EditItemActivity.Position,pos);
                callEdit.putExtra(EditItemActivity.ToDoItem,items.get(pos));

                startActivityForResult(callEdit,EditItemActivity.EDIT_REQUEST_CODE);
            }
        });
    }

    public void onAddItem(View v)    {
        Intent callAdd = new Intent(MainActivity.this, EditItemActivity.class);
        callAdd.putExtra(EditItemActivity.AddItemRequest, true);
        startActivityForResult(callAdd,EditItemActivity.EDIT_REQUEST_CODE);

        //WriteItems();
    }

    private void ReadItems()    {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir,"todo.txt");
        try {
            ArrayList<String> itemsFromFile = new ArrayList<>(FileUtils.readLines(todoFile));
            items = new ArrayList<>();
        }
        catch (IOException e) {
            items = new ArrayList<>();
        }
    }

    private void WriteItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir,"todo.txt");

        try {
            FileUtils.writeLines(todoFile,items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
