package test.codepath.aaneja.simpletodo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import test.codepath.aaneja.simpletodo.models.ToDoItem;

public class EditItemActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static final int EDIT_REQUEST_CODE = 449;

    //TODO: Need to figure out if request codes can be used to signal intent
    public static final String AddItemRequest = "AddItemRequest";

    public static final String Position = "position";
    public static final String ToDoItem = "todoValue";

    private int position;
    private boolean addItemRequest = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Intent inbound = getIntent();

        addItemRequest = inbound.getBooleanExtra(AddItemRequest, false);

        if (addItemRequest)
        {
            TextView tvEditDate = (TextView) findViewById(R.id.tvEditDate);
            tvEditDate.setText(dateFormat.format(Calendar.getInstance().getTime()));
            return;
        }

        position = inbound.getIntExtra(Position,0);

        ToDoItem itemToAddEdit = inbound.getParcelableExtra(ToDoItem);
        if(itemToAddEdit != null)
        {
            EditText etNewText = (EditText) findViewById(R.id.editText);
            etNewText.setText(itemToAddEdit.Name);

            TextView tvEditDate = (TextView) findViewById(R.id.tvEditDate);
            tvEditDate.setText(dateFormat.format(itemToAddEdit.DueDate));
        }
    }

    public void onSave(View v) throws ParseException {
        EditText etUpdatedText = (EditText) findViewById(R.id.editText);
        TextView tvEditDate = (TextView) findViewById(R.id.tvEditDate);
        ToDoItem updatedToDoItem = new ToDoItem(etUpdatedText.getText().toString(),dateFormat.parse(tvEditDate.getText().toString()));

        Intent data = new Intent();
        data.putExtra(ToDoItem, updatedToDoItem);

        if(addItemRequest) {
            data.putExtra(AddItemRequest,true);
        }
        else  {
            data.putExtra(Position, position);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    // handle the date selected
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        TextView tvEditDate = (TextView) findViewById(R.id.tvEditDate);
        tvEditDate.setText(dateFormat.format(c.getTime()));
    }
}
