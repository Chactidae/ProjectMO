package com.example.projectmo.ui.dashboard;

import java.util.ArrayList;

public class Schedule {

    private String[] timeJob;
    private String fio;
    private String jobDateStart;
    private String getJobDateEnd;

    public Schedule(String fio, String[] timeJob, String jobDateStart, String getJobDateEnd){
        this.fio = fio;
        this.timeJob = timeJob;
        this.jobDateStart = jobDateStart;
        this.getJobDateEnd = getJobDateEnd;

        //String[] timeJob1 = {"7:30", "10:50", "18:20"};
        //String[] timeJob2 = {"9:30", "12:30", "15:20"};
        //String[] timeJob3 = {"8:10", "13:30", "16:00"};
        //String[] timeJob4 = {"10:45", "14:10", "20:10"};

    }

    public String getFio() {
        return fio;
    }

    public String[] getTimeJob() {
        return timeJob;
    }

    public String getJobDateStart() {
        return jobDateStart;
    }

    public String getGetJobDateEnd() {
        return getJobDateEnd;
    }
}
