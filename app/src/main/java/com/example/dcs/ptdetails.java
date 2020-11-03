package com.example.dcs;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ptdetails {

    private String pateintId;
    private String pateintName;
    private String pateintEmail;
    private String pateintphone;

    public ptdetails(){
        //this constructor is required
    }

    public ptdetails(String pateintId, String pateintName, String pateintEmail, String pateintphone) {
        this.pateintId = pateintId;
        this.pateintName = pateintName;
        this.pateintEmail = pateintEmail;
        this.pateintphone = pateintphone;
    }

    public String getPateintId() {
        return pateintId;
    }

    public String getPateintName() {
        return pateintName;
    }

    public String getPateintEmail() {
        return pateintEmail;
    }

    public String getPateintphone() {
        return pateintphone;
    }
}
