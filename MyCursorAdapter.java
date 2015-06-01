package com.example.daniel.koerelogbogapp;

/**
 * Created by Daniel on 29-05-2015.
 */

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.R;

import java.util.ArrayList;

/**
 * Created by Daniel on 4/14/2015.
 */
public class MyCursorAdapter extends SimpleCursorAdapter {

    private LayoutInflater cursorInflater;
    private View convertView;
    private int counter;
    public static ArrayList<Integer> ids;
    private Context context;

    public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        counter = 0;
        ids = new ArrayList<>();
        this.context = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return cursorInflater.inflate(R.layout.list_item, parent, false);
    }

    @Override
    public int getViewTypeCount() { return 1; }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        View rootView = view;

        if (convertView == null) {
            //Locate all the views relevant to the listView elements
            final TextView title = (TextView) rootView.findViewById(R.id.title);
//            final TextView description = (TextView) rootView.findViewById(R.id.description);
//            final TextView distanceTo = (TextView) rootView.findViewById(R.id.distance);
//            final ImageView imageView = (ImageView) rootView.findViewById(R.id.listImage);


            //Load image from web in a separate thread
            ids.add(counter++, cursor.getInt(cursor.getColumnIndex(DatabaseHandler.ID)));
            String imageUri = cursor.getString(cursor.getColumnIndex(DatabaseHandler.SSN));
            if (!imageUri.equals("")) {

            }

        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();

    }


}
