package com.example.projectmo.ui.dashboard;

import android.app.Application;

import java.util.ArrayList;
import java.util.Objects;


public class ScheduleList extends Application {
    private static ArrayList<Schedule> ScheduleArr = new ArrayList<>();

    public ScheduleList(){
    }
    public void addSchedule(Schedule schedule){
        ScheduleArr.add(schedule);
    }
    public Schedule getSchedule(String fio){
        for (Schedule schedule: ScheduleArr) {
            if (Objects.equals(schedule.getFio(), fio)){
              return schedule;
            }

        }
        return null;
    }
}
