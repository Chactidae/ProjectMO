package com.example.projectmo.ui.home;

import static com.example.projectmo.ui.home.HomeFragment.inSin;
import static com.example.projectmo.ui.home.ProfileFragment.appointmentList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projectmo.databinding.FragmentNotificationsBinding;
import com.example.projectmo.ui.dashboard.AppAdapter;
import com.example.projectmo.ui.dashboard.Appointment;
import com.example.projectmo.ui.dashboard.Schedule;
import com.example.projectmo.ui.dashboard.ScheduleList;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private static ArrayList<Appointment> emptyList = new ArrayList<>();
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        Bundle bundle = getArguments();
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ListView listView = binding.listViewApp;
        if(inSin) {
            AppAdapter adapter = new AppAdapter(getContext(), appointmentList);
            listView.setAdapter(adapter);
        }
        else {
            AppAdapter adapter = new AppAdapter(getContext(), emptyList);
            listView.setAdapter(adapter);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}