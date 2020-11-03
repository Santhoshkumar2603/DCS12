package com.example.dcs;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Appointmentpatient {
    private String appointerid;
    private String appointername;
    private String appointerage;
    private String appointerdob;
    private String appointerphone;
    private String appointeraddress;
    private String appointerbloodgrp;
    private String appointergender;
    private String appointmentdprt;
    private String appointmenttime;
    private String appointmentdate;

    public Appointmentpatient(){
        //this constructor is required
    }

    public Appointmentpatient(String appointerid, String appointername, String appointerage, String appointerdob, String appointerphone, String appointeraddress, String appointerbloodgrp, String appointergender, String appointmentdprt, String appointmenttime, String appointmentdate) {
        this.appointerid = appointerid;
        this.appointername = appointername;
        this.appointerage = appointerage;
        this.appointerdob = appointerdob;
        this.appointerphone = appointerphone;
        this.appointeraddress = appointeraddress;
        this.appointerbloodgrp = appointerbloodgrp;
        this.appointergender = appointergender;
        this.appointmentdprt = appointmentdprt;
        this.appointmenttime = appointmenttime;
        this.appointmentdate = appointmentdate;
    }

    public String getAppointerid() {
        return appointerid;
    }

    public String getAppointername() {
        return appointername;
    }

    public String getAppointerage() {
        return appointerage;
    }

    public String getAppointerdob() {
        return appointerdob;
    }

    public String getAppointerphone() {
        return appointerphone;
    }

    public String getAppointeraddress() {
        return appointeraddress;
    }

    public String getAppointerbloodgrp() {
        return appointerbloodgrp;
    }

    public String getAppointergender() {
        return appointergender;
    }

    public String getAppointmentdprt() {
        return appointmentdprt;
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public String getAppointmentdate() {
        return appointmentdate;
    }
}

