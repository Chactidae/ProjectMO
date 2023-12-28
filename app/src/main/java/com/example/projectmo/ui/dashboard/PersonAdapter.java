package com.example.projectmo.ui.dashboard;

import static android.app.PendingIntent.getActivity;
import static com.example.projectmo.R.drawable.profile_image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;

import com.example.projectmo.R;
import com.example.projectmo.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<Person> personList;

    public PersonAdapter(Context context, ArrayList<Person> personList) {
        super(context, 0, personList);
        //mContext = context;
        inflater = LayoutInflater.from(context);
        this.personList = personList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.person, parent, false);
        }


        Person person = personList.get(position);
        ImageView imageView = view.findViewById(R.id.profile_image);
        TextView firstNameTextView = view.findViewById(R.id.full_name);
        TextView lastNameTextView = view.findViewById(R.id.price);
        imageView.setImageResource(person.getAvatar());
        firstNameTextView.setText(person.getFio());
        lastNameTextView.setText(person.getService());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", person.getFio());
                bundle.putString("price", person.getPrice());
                bundle.putString("service", person.getService());
                bundle.putInt("image", person.getAvatar());
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_navigation_profile, bundle);
            }
        });

        return view;
    }
}
