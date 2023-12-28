package com.example.projectmo.ui.dashboard;

import android.widget.ImageView;

import java.sql.Time;
import java.util.Date;

public class Person {

    private String fio;
    private String price;
    private int avatar;
    private String service;

    public Person(String name, String price, int avatar, String service){
        this.fio = name;
        this.price = price;
        this.avatar = avatar;
        this.service = service;
    }

    public String getFio() {
        return fio;
    }

    public String getPrice() {
        return price;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getService() {
        return service;
    }
}
