package com.example.projectmo.ui.home;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.projectmo.MainActivity;
import com.example.projectmo.R;
import com.example.projectmo.ui.dashboard.User;
import com.example.projectmo.ui.dashboard.UserManagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegistrationFragment extends Fragment {
    private String selectedDateString;
    public RegistrationFragment(){

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.registration, container, false);
        EditText fioText = view.findViewById(R.id.editTextFullName);
        EditText emailText = view.findViewById(R.id.textEmail);
        EditText passwordText = view.findViewById(R.id.editTextPassword);
        EditText phone_numText = view.findViewById(R.id.editTextPhoneNumber);
        DatePicker born = view.findViewById(R.id.datePicker);
        String date;
        born.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Получаем выбранную дату
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, monthOfYear, dayOfMonth);

                // сохраняем выбранную дату в нужном формате
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                selectedDateString = dateFormat.format(selectedDate.getTime());

            }
        });

        Button reg_butt = view.findViewById(R.id.buttonRegister);
        reg_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fio = String.valueOf(fioText.getText());
                String email = String.valueOf(emailText.getText());
                String password = String.valueOf(passwordText.getText());
                String phone_num = String.valueOf(phone_numText.getText());
                Bundle bundle = new Bundle();
                bundle.putString("date", selectedDateString);
                UserManagement userManagement = new UserManagement(getContext());
                boolean isReg = userManagement.registerUser(fio, email, password, phone_num, selectedDateString);
                if(isReg) {
                    Navigation.findNavController(v).navigate(R.id.action_navigation_reg_to_navigation_auth, bundle);
                }

            }
        });

        return view;
    }


}
