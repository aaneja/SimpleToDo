package test.codepath.aaneja.simpletodo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.codepath.aaneja.simpletodo.R;
import test.codepath.aaneja.simpletodo.models.ToDoItem;

/**
 * Created by aaneja on 18/02/17.
 */

public class ToDoItemAdapter extends ArrayAdapter<ToDoItem>{

    public ToDoItemAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ToDoItem user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todoitem, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvDueDate = (TextView) convertView.findViewById(R.id.tvDueDate);
        // Populate the data into the template view using the data object
        tvName.setText(user.Name);
        tvDueDate.setText(user.DueDate.toString());
        // Return the completed view to render on screen
        return convertView;

    }
}
