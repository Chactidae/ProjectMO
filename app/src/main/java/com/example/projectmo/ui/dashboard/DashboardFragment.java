package com.example.projectmo.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projectmo.R;
import com.example.projectmo.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = binding.listView;

        final ArrayList<Person> personsList = new ArrayList<>();
        personsList.add(new Person("Иванов Павел Романович", "3000", R.drawable.profile_image6, "Офтальмолог"));
        personsList.add(new Person("Сосновщенко Олег Игоревич", "1000", R.drawable.profile_image2, "Хирург"));
        personsList.add(new Person("Мельников Павел Владимирович", "5000", R.drawable.profile_image2, "Травматолог"));
        personsList.add(new Person("Войтенко Константин Степанович", "1000", R.drawable.profile_image5, "Дерматолог"));
        personsList.add(new Person("Петров Артём Владимирович", "3000", R.drawable.profile_image6, "Офтальмолог"));
        personsList.add(new Person("Холодов Иван Владимирович", "4500", R.drawable.profile_image6, "Травматолог"));
        personsList.add(new Person("Павлова Алиса Сергеевна", "1500", R.drawable.profile_image3, "Хирург"));
        personsList.add(new Person("Иванова Мария Алексеевна", "2300", R.drawable.prifile_image7, "Диетолог"));
        personsList.add(new Person("Сосновщенко Софья Викторовна", "6000", R.drawable.prifile_image7, "Невропатолог"));

        ScheduleList scheduleList = new ScheduleList();
        String[] timeJob1 = {"7:30", "10:50", "12:15", "13:30", "16:45", "18:20"};
        String[] timeJob2 = {"8:00", "9:35", "15:20"};
        scheduleList.addSchedule(new Schedule("Павлова Алиса Сергеевна", timeJob1, "December 26, 2023", "January 5, 2024"));
        scheduleList.addSchedule(new Schedule("Сосновщенко Олег Игоревич", timeJob2, "January 2, 2024", "January 7, 2024"));
        scheduleList.addSchedule(new Schedule("Иванов Павел Романович", timeJob1, "December 26, 2023", "January 5, 2024"));
        scheduleList.addSchedule(new Schedule("Мельников Павел Владимирович", timeJob1, "December 26, 2023", "January 5, 2024"));
        scheduleList.addSchedule(new Schedule("Войтенко Константин Степанович", timeJob2, "January 2, 2024", "January 7, 2024"));
        scheduleList.addSchedule(new Schedule("Петров Артём Владимирович", timeJob2, "January 2, 2024", "January 7, 2024"));
        scheduleList.addSchedule(new Schedule("Холодов Иван Владимирович", timeJob1, "January 2, 2024", "January 7, 2024"));
        scheduleList.addSchedule(new Schedule("Иванова Мария Алексеевна", timeJob1, "January 2, 2024", "January 7, 2024"));
        scheduleList.addSchedule(new Schedule("Сосновщенко Софья Викторовна", timeJob2, "January 2, 2024", "January 7, 2024"));


        final PersonAdapter adapter = new PersonAdapter(getContext(), personsList);
        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}