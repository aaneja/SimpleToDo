package test.codepath.aaneja.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvItems;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById(R.id.lvItems);
        //items = new ArrayList<>();
        ReadItems();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        lvItems.setAdapter(itemsAdapter);
        //items.add("First Item");
        //items.add("Second Item");

        SetupListViewListener();
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
    }

    public void onAddItem(View v)    {
        EditText etNewText = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewText.getText().toString();

        itemsAdapter.add(itemText);
        etNewText.setText("");
        WriteItems();
    }

    private void ReadItems()    {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir,"todo.txt");
        try {
            items = new ArrayList<>(FileUtils.readLines(todoFile));
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
