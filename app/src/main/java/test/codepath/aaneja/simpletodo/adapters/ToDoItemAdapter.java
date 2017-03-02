package test.codepath.aaneja.simpletodo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import test.codepath.aaneja.simpletodo.R;
import test.codepath.aaneja.simpletodo.models.ToDoItem;

/**
 * Created by aaneja on 18/02/17.
 */

public class ToDoItemAdapter extends ArrayAdapter<ToDoItem>{

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView dueDate;
    }

    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

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

            // Lookup view for data population
            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            TextView tvDueDate = (TextView) convertView.findViewById(R.id.tvDueDate);
            // Populate the data into the template view using the data object
            tvName.setText(user.Name);
            tvDueDate.setText(df.format(user.DueDate));

            ViewHolder toCache = new ViewHolder();
            toCache.name = tvName;
            toCache.dueDate = tvDueDate;
            convertView.setTag(toCache);
        }
        else {
            ViewHolder cached = (ViewHolder) convertView.getTag();
            cached.name.setText(user.Name);
            cached.dueDate.setText(df.format(user.DueDate));
        }

        // Return the completed view to render on screen
        return convertView;

    }
}
