package com.example.daniel.koerelogbogapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentValues;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class CreateEntryFragment extends Fragment {

    private int chosenItem;
    private Spinner spinner;
    private createEntryFromExistingCompanies createEntryFromExistingCompanies;
    private createEntryWithManualInput createEntryWithManualInput;
    private View rootView;
    private MainActivity superActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_entry, container, false);
        rootView = view;
            spinner = (Spinner) view.findViewById(R.id.spinner);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onSpinnerClicked(spinner);
        }

            @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
        });

        ((Button) view.findViewById(R.id.savebutton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveButtonClicked();
            }
        });

        if(view.findViewById(R.id.EntryCreationFragment) != null) {
            createEntryWithManualInput = new createEntryWithManualInput();
            getFragmentManager().beginTransaction().add(R.id.EntryCreationFragment, createEntryWithManualInput).commit();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.menu_create_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setActivity(MainActivity activity){
        this.superActivity = activity;
    }

    public void onSpinnerClicked(Spinner spinner) {

        switch (spinner.getSelectedItemPosition()) {
            case 0:
                chosenItem = 0;
                createEntryWithManualInput = new createEntryWithManualInput();
                getFragmentManager().beginTransaction().add(R.id.EntryCreationFragment, createEntryWithManualInput).commit();
                break;
            case 1:
                chosenItem = 1;
                createEntryFromExistingCompanies = new createEntryFromExistingCompanies();
                getFragmentManager().beginTransaction().add(R.id.EntryCreationFragment, createEntryFromExistingCompanies).commit();
                break;

        }
    }

    public void onSaveButtonClicked(){
        ContentValues values = new ContentValues();

        EditText DriversName = (EditText) rootView.findViewById(R.id.inputDriversName);
        EditText drivingPurpose = (EditText) rootView.findViewById(R.id.inputPurpose);
        EditText entryFrom = (EditText) rootView.findViewById(R.id.inputCompanyName);
        EditText entryTo = (EditText) rootView.findViewById(R.id.inputDriversName);
        EditText licensePlate = (EditText) rootView.findViewById(R.id.inputLicensePlate);
        EditText odometerFrom = (EditText) rootView.findViewById(R.id.inputOdoFrom);
        EditText odometerTo = (EditText) rootView.findViewById(R.id.inputOdoTo);
        EditText SSN = (EditText) rootView.findViewById(R.id.inputSSN);
        values.put(DriversName.getText().toString(), DatabaseHandler.DRIVERS_NAME);
        values.put(drivingPurpose.getText().toString(), DatabaseHandler.DRIVING_PURPOSE);
        values.put(entryFrom.getText().toString(), DatabaseHandler.DEPARTURE_POINT);
        values.put(entryTo.getText().toString(), DatabaseHandler.DESTINATION);
        values.put(licensePlate.getText().toString(), DatabaseHandler.LICENSE_PLATE);
        values.put(odometerFrom.getText().toString(), DatabaseHandler.ODOMETER_FROM);
        values.put(odometerTo.getText().toString(), DatabaseHandler.ODOMETER_TO);
        values.put(SSN.getText().toString(), DatabaseHandler.SSN);

        switch (chosenItem) {
            case 0:
                values.put(createEntryWithManualInput.getCompanyAddress(), DatabaseHandler.COMPANY_ADDRESS);
                values.put(createEntryWithManualInput.getCompanyName(), DatabaseHandler.COMPANY_NAME);
                break;
            case 1:

                break;
        }

        DatabaseHandler.insert(values);
        superActivity.setFragmentToViewEntries();
    }
}
