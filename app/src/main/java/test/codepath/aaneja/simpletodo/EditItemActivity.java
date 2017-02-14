package test.codepath.aaneja.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    public static final int EDIT_REQUEST_CODE = 449;
    private int position;
    private String todoVaule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Intent inbound = getIntent();
        position = inbound.getIntExtra("position",0);
        todoVaule = inbound.getStringExtra("todoValue");

        EditText etNewText = (EditText) findViewById(R.id.editText);
        etNewText.setText(todoVaule);
    }

    public void onSubmit(View v) {

    }
}