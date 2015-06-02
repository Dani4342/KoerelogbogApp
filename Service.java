package com.example.daniel.koerelogbogapp;

import android.content.ContentValues;

import java.util.Date;

/**
 * Created by Daniel on 01-06-2015.
 */
public class Service {

    public Service(){
    }

    public void GenerateTestData(){
        ContentValues values = new ContentValues();

        values.put("Ole Hansen", DatabaseHandler.DRIVERS_NAME);
        values.put("Hjemmehjælp", DatabaseHandler.DRIVING_PURPOSE);
        values.put("Hjemme", DatabaseHandler.DEPARTURE_POINT);
        values.put("Berit, 8700 Horsens", DatabaseHandler.DESTINATION);
        values.put("QD 78 956", DatabaseHandler.LICENSE_PLATE);
        values.put("22.564", DatabaseHandler.ODOMETER_FROM);
        values.put("22.600", DatabaseHandler.ODOMETER_TO);
        values.put("24-02-1990-1234", DatabaseHandler.SSN);
        values.put("Birkevej 12", DatabaseHandler.COMPANY_ADDRESS);
        values.put("Egekilden", DatabaseHandler.COMPANY_NAME);
        values.put(KIND_OF_TRIP.WORK_TO_WORK.toString(), DatabaseHandler.KIND_OF_TRIP_ENUM);


        DatabaseHandler.insert(values);

        values = new ContentValues();

        values.put("Bo Henriksen", DatabaseHandler.DRIVERS_NAME);
        values.put("Skadedyrsbekæmper", DatabaseHandler.DRIVING_PURPOSE);
        values.put("Bugs_R_Us", DatabaseHandler.DEPARTURE_POINT);
        values.put("Miriam, 7200 Vejle", DatabaseHandler.DESTINATION);
        values.put("XZ 32 927", DatabaseHandler.LICENSE_PLATE);
        values.put("65.345", DatabaseHandler.ODOMETER_FROM);
        values.put("65.450", DatabaseHandler.ODOMETER_TO);
        values.put("31-09-1987-6547", DatabaseHandler.SSN);
        values.put("Lærkevej 43, Grindsted", DatabaseHandler.COMPANY_ADDRESS);
        values.put("Bugs_R_Us", DatabaseHandler.COMPANY_NAME);
        DatabaseHandler.insert(values);
    }

}
