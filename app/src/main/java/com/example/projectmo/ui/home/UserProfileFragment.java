package com.example.projectmo.ui.home;

import static com.example.projectmo.ui.home.HomeFragment.inSin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.projectmo.R;
import com.example.projectmo.databinding.FragmentHomeBinding;
import com.example.projectmo.ui.dashboard.UserManagement;

public class UserProfileFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.user_profile, container, false);
        Bundle bundle = getArguments();
        assert bundle != null;
        inSin = true;
        String[] user_info = loadUserInfo(bundle.getString("email"), bundle.getString("password"));
        TextView fio = view.findViewById(R.id.editTextFullName);
        TextView email = view.findViewById(R.id.editTextEmail);
        TextView phone = view.findViewById(R.id.editTextPhoneNumber);
        TextView birthday = view.findViewById(R.id.editTextDateOfBirth);
        fio.setText(user_info[0]);
        email.setText(user_info[1]);
        phone.setText(user_info[2]);
        birthday.setText(user_info[3]);

        Button btn_exit = view.findViewById(R.id.buttonExit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inSin = false;
                Navigation.findNavController(v).navigate(R.id.action_navigation_user_profile_to_navigation_home2);
            }
        });

        return view;
    }
    private String[] loadUserInfo(String email, String password){
        UserManagement userManagement = new UserManagement(getContext());
        return userManagement.getInfo(email, password);
    }
}
