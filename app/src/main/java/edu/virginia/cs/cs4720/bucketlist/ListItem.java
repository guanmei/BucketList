package edu.virginia.cs.cs4720.bucketlist;

import java.io.Serializable;

/**
 * Created by gl5pc on 2/13/2016.
 *
 * POJO for the to-do items in the bucket list
 */
public class ListItem implements Serializable {

    private static final long serialVersionUID = 0L;

    int id;
    boolean completed;
    String title;
    String description;

    public ListItem() {
        super();
    }

    public ListItem(int id, boolean c, String t, String d) {
        this.id = id;
        completed = c;
        title = t;
        description = d;
    }



    @Override
    public String toString() {
        return title;
    }
}
