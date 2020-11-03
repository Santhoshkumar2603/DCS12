package com.example.dcs;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class MsgConv {

    private String busId;
    private String busstop1;

    public MsgConv(){
        //this constructor is required
    }

    public MsgConv(String busId, String busstop1) {
        this.busId = busId;
        this.busstop1 = busstop1;

    }

    public String getBusId() {
        return busId;
    }

    public String getBusstop1() {
        return busstop1;
    }

}
