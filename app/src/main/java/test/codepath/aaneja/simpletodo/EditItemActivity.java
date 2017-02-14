package test.codepath.aaneja.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    public static final int EDIT_REQUEST_CODE = 449;
    public static final String Position = "position";
    public static final String ToDoVaule = "todoValue";

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Intent inbound = getIntent();
        position = inbound.getIntExtra(Position,0);

        EditText etNewText = (EditText) findViewById(R.id.editText);
        etNewText.setText(inbound.getStringExtra(ToDoVaule));
    }

    public void onSave(View v) {
       EditText etUpdatedText = (EditText) findViewById(R.id.editText);

        Intent data = new Intent();
        data.putExtra(ToDoVaule, etUpdatedText.getText().toString());
        data.putExtra(Position, position);

        setResult(RESULT_OK, data);
        finish();
    }
}
