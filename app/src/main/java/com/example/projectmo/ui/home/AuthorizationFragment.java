package com.example.projectmo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.projectmo.MainActivity;
import com.example.projectmo.R;
import com.example.projectmo.databinding.FragmentHomeBinding;
import com.example.projectmo.ui.dashboard.Person;
import com.example.projectmo.ui.dashboard.User;
import com.example.projectmo.ui.dashboard.UserManagement;

public class AuthorizationFragment extends Fragment {
    private FragmentHomeBinding binding;
    public AuthorizationFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.authorization, container, false);
        Bundle bundle = getArguments();
        Button auth_butt = view.findViewById(R.id.buttonAuth);
        EditText emailText = view.findViewById(R.id.textEmail);
        EditText passwordText = view.findViewById(R.id.textPassword);
        TextView verification = view.findViewById(R.id.textView3);
        auth_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(emailText.getText());
                String password = String.valueOf(passwordText.getText());
                UserManagement userManagement = new UserManagement(getContext());
                boolean sin = userManagement.authenticateUser(email, password);
                if (sin){
                    verification.setText("Вы успешно вошли :)");
                    Bundle bundle = new Bundle();
                    bundle.putString("email", email);
                    bundle.putString("password", password);
                    Navigation.findNavController(v).navigate(R.id.action_navigation_auth_to_navigation_user_profile, bundle);

                }
                else{
                    verification.setText("Неверный пароль!");
                }
            }
        });
        return view;
    }
}
