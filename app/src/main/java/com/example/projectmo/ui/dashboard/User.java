package com.example.projectmo.ui.dashboard;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String fio;
    private String email;
    private String password;
    private String phone;
    private String date;

    private ArrayList<Appointment> appointments;

    public User(String fio, String email, String password, String phone, String date){
        this.fio = fio;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.date = date;
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
    public String getFio() {
        return fio;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }
}
