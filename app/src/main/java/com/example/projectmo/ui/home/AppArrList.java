package com.example.projectmo.ui.home;

import com.example.projectmo.ui.dashboard.Appointment;
import com.example.projectmo.ui.dashboard.Schedule;

import java.util.ArrayList;
import java.util.Objects;

public class AppArrList {
    private static ArrayList<ArrayList<Appointment>> users_app = new ArrayList<>();

    public AppArrList(){

    }
    public void addUserApps(ArrayList<Appointment> user_apps){
        users_app.add(user_apps);
    }

}
