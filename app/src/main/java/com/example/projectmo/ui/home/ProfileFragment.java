package com.example.projectmo.ui.home;

import static com.example.projectmo.ui.home.HomeFragment.inSin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.projectmo.R;
import com.example.projectmo.ui.dashboard.AppAdapter;
import com.example.projectmo.ui.dashboard.Appointment;
import com.example.projectmo.ui.dashboard.Person;
import com.example.projectmo.ui.dashboard.Schedule;
import com.example.projectmo.ui.dashboard.ScheduleList;

import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProfileFragment extends Fragment {
    private String[] timeJob = {"7:30", "10:50", "18:20"};
    private String dateApp;
    private Boolean state;
    public static ArrayList<Appointment> appointmentList = new ArrayList<>();
    public static AppAdapter adapter1;
    public static String time;
    public ProfileFragment() {
        // Пустой конструктор требуется для фрагментов
    }

    @SuppressLint({"SetTextI18n", "NewApi"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.profile, container, false);
        TextView fio = view.findViewById(R.id.textFio);
        TextView price = view.findViewById(R.id.textPrice);
        TextView service = view.findViewById(R.id.textExperience);
        assert bundle != null;
        Button addTo = view.findViewById(R.id.addTo);
        String name = bundle.getString("name");
        String person_price = bundle.getString("price");
        String person_service = bundle.getString("service");
        int image = bundle.getInt("image");
        ImageView imageView = view.findViewById(R.id.profile_image_curr);
        imageView.setImageResource(image);
        fio.setText(name);
        price.setText(person_price + " руб.");
        service.setText(person_service);
        DatePicker datePicker = view.findViewById(R.id.datePickerPerson);
        Spinner spinner = view.findViewById(R.id.spTime);

        // DataPicker
        Calendar startCal = Calendar.getInstance();
        ScheduleList scheduleList = new ScheduleList();
        Schedule doctor = scheduleList.getSchedule(name);
        String startDate = doctor.getJobDateStart();
        String endDate = doctor.getGetJobDateEnd();
        timeJob = doctor.getTimeJob();
        Date thedate = null;
        Date theEndDate = null;
        try {
            thedate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(startDate);
            theEndDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(endDate);
            assert thedate != null;
            startCal.setTime(thedate);
            Calendar endCal = Calendar.getInstance();
            assert theEndDate != null;
            endCal.setTime(theEndDate);
            //endCal.add(Calendar.DATE, 6);
            datePicker.setMinDate(startCal.getTimeInMillis());
            datePicker.setMaxDate(endCal.getTimeInMillis());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date currDate = Calendar.getInstance().getTime();
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Получаем выбранную дату
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, monthOfYear, dayOfMonth);
                if (selectedDate.getTime().before(currDate)){
                    state = true;
                }
                else{
                    state = false;
                }
                // сохраняем выбранную дату в нужном формате
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateApp = dateFormat.format(selectedDate.getTime());
            }
        });
        // TimePicker
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, timeJob);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if (inSin){
            addTo.setEnabled(true);
        }
        else {
            addTo.setEnabled(false);
        }


        addTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle bundle = new Bundle();
                //bundle.putString("dateApp", dateApp);
                //bundle.putString("fio", name);
               // bundle.putString("service", person_service);
                //bundle.putBoolean("state", state);
                //Navigation.findNavController(v).navigate(R.id.action_navigation_profile_to_navigation_notifications, bundle);
                String appTime = spinner.getSelectedItem().toString();
                time = appTime;
                ListView listView = v.findViewById(R.id.listViewApp);
                appointmentList.add(new Appointment(name, person_service, dateApp, state, appTime));
                adapter1 = new AppAdapter(getContext(), appointmentList);
                Navigation.findNavController(v).navigate(R.id.action_navigation_profile_to_navigation_dashboard2);
            }
        });

        return view;
    }


}