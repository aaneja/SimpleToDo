package test.codepath.aaneja.simpletodo.models;

import java.util.Date;

/**
 * Created by aaneja on 18/02/17.
 */

public class ToDoItem {
    public String Name;
    public Date DueDate;

    public ToDoItem(String name, Date dueDate) {
        Name = name;
        DueDate = dueDate;
    }
}
