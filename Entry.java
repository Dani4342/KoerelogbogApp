package com.example.daniel.koerelogbogapp;

import java.util.Date;

/**
 * Created by Daniel on 27-05-2015.
 */
public class Entry {

    private Date entryDate;
    private String LicensePlate;
    private String entryFrom;
    private String entryTo;
    private String drivingPurpose;
    private String driversName;
    private String companyName;
    private String companyAddress;
    private int odometerFrom;
    private int odometerTo;
    private int SSN;

    public Entry(){

    }

    public String getCompanyAddress() { return companyAddress; }

    public void setCompanyAddress(String companyAddress) { this.companyAddress = companyAddress; }

    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public int getSSN() { return SSN; }

    public void setSSN(int SSN) { this.SSN = SSN; }

    public String getDriversName() { return driversName; }

    public void setDriversName(String driversName) { this.driversName = driversName; }

    public int getOdometerTo() { return odometerTo; }

    public void setOdometerTo(int odometerTo) { this.odometerTo = odometerTo; }

    public Date getEntryDate() { return entryDate; }

    public void setEntryDate(Date entryDate) { this.entryDate = entryDate; }

    public String getLicensePlate() { return LicensePlate; }

    public void setLicensePlate(String licensePlate) { LicensePlate = licensePlate; }

    public String getEntryFrom() { return entryFrom; }

    public void setEntryFrom(String entryFrom) { this.entryFrom = entryFrom; }

    public String getEntryTo() { return entryTo; }

    public void setEntryTo(String entryTo) { this.entryTo = entryTo; }

    public String getDrivingPurpose() { return drivingPurpose; }

    public void setDrivingPurpose(String drivingPurpose) { this.drivingPurpose = drivingPurpose; }

    public int getOdometerFrom() { return odometerFrom; }

    public void setOdometerFrom(int odometerFrom) { this.odometerFrom = odometerFrom; }
}
