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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
            final TextView dateDriven = (TextView) rootView.findViewById(R.id.dateDriven);
            final TextView description = (TextView) rootView.findViewById(R.id.description);
            final TextView distanceDriven = (TextView) rootView.findViewById(R.id.distanceDriven);
            final TextView driversName = (TextView) rootView.findViewById(R.id.driversName);
            final TextView licensePlate = (TextView) rootView.findViewById(R.id.carsLicensePlate);


            dateDriven.setText(cursor.getString(cursor.getColumnIndex(DatabaseHandler.DATE)));
            description.setText(cursor.getString(cursor.getColumnIndex(DatabaseHandler.DRIVING_PURPOSE)));
            distanceDriven.setText(String.valueOf(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DatabaseHandler.ODOMETER_TO))) - Integer.parseInt(cursor.getString(cursor.getColumnIndex(DatabaseHandler.ODOMETER_FROM)))));
            driversName.setText(cursor.getString(cursor.getColumnIndex(DatabaseHandler.DRIVERS_NAME)));
            licensePlate.setText(cursor.getString(cursor.getColumnIndex(DatabaseHandler.LICENSE_PLATE)));
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public ArrayList<Entry> getSpecificEntries(Date startDate, Date endDate, final Cursor cursor){
        ArrayList<Entry> temp = new ArrayList<Entry>();
        while(cursor.moveToNext()){
            DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date = null;
            try {
                date = df.parse(cursor.getString(cursor.getColumnIndex(DatabaseHandler.DATE)));

            } catch (java.text.ParseException e) {}

            if (date.before(endDate) && date.after(startDate)) {
                
            }
        }
        return (ArrayList<Entry>) temp.clone();
    }


}
