package com.example.projectmo.ui.dashboard;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Appointment {

    private String user_fio;
    private String doc_fio;
    private String service;
    private boolean state;
    private String date;
    private String time;

    public Appointment(String doc_fio, String service, String date, Boolean state, String time){
        this.doc_fio = doc_fio;
        this.service = service;
        this.date = date;
        this.state = state;
        this.time = time;
    }
    public Boolean isState(){
        return state;
    }



    public String getDoc_fio() {
        return doc_fio;
    }

    public String getService() {
        return service;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
