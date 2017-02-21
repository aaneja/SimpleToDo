package test.codepath.aaneja.simpletodo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by aaneja on 18/02/17.
 */

public class ToDoItem implements Parcelable {
    public String Name;
    public Date DueDate;

    public ToDoItem(String name, Date dueDate) {
        Name = name;
        DueDate = dueDate;
    }

    public ToDoItem() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeLong(this.DueDate != null ? this.DueDate.getTime() : -1);
    }

    protected ToDoItem(Parcel in) {
        this.Name = in.readString();
        long tmpDueDate = in.readLong();
        this.DueDate = tmpDueDate == -1 ? null : new Date(tmpDueDate);
    }

    public static final Creator<ToDoItem> CREATOR = new Creator<ToDoItem>() {
        @Override
        public ToDoItem createFromParcel(Parcel source) {
            return new ToDoItem(source);
        }

        @Override
        public ToDoItem[] newArray(int size) {
            return new ToDoItem[size];
        }
    };
}
