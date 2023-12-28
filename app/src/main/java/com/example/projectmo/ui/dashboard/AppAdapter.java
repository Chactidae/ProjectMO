package com.example.projectmo.ui.dashboard;

import static android.view.View.INVISIBLE;

import static com.example.projectmo.ui.home.ProfileFragment.time;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectmo.R;

import java.util.ArrayList;
import java.util.Objects;

public class AppAdapter extends ArrayAdapter<Appointment> {
    private LayoutInflater inflater;
    private ArrayList<Appointment> appList;

    public AppAdapter(Context context, ArrayList<Appointment> appList) {
        super(context, 0, appList);
        //mContext = context;
        inflater = LayoutInflater.from(context);
        this.appList = appList;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.appointment, parent, false);
        }

        Appointment appointment = appList.get(position);
        ImageView state = view.findViewById(R.id.app_state);
        TextView fio = view.findViewById(R.id.fio_app);
        TextView price = view.findViewById(R.id.service_app);
        TextView dateText = view.findViewById(R.id.date_TextApp);
        ImageButton remove = view.findViewById(R.id.removeApp);
        TextView stateText = view.findViewById(R.id.stateText);
        if (appointment.isState()) {
            state.setImageResource(android.R.drawable.presence_online);
            remove.setVisibility(INVISIBLE);
            stateText.setText("Услуга оказана");
        } else {
            state.setImageResource(android.R.drawable.presence_away);
            stateText.setText("В обработке");
        }
        fio.setText(appointment.getDoc_fio());
        price.setText(appointment.getService());
        dateText.setText(appointment.getDate() + " Время:" + appointment.getTime());
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appList.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
