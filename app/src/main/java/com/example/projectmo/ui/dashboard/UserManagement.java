package com.example.projectmo.ui.dashboard;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class UserManagement {
    private ArrayList<User> userList;
    DBHelper DB;

    private boolean isSin = false;
    private boolean isReg = false;

    public UserManagement(Context context) {
        DB = new DBHelper(context);
    }


    // Метод для регистрации нового пользователя
    public boolean registerUser(String fio, String email, String password, String phone, String date) {
        User user = new User(fio, email, password, phone, date);
        Boolean checkuser = DB.checkname(user.getEmail(), user.getPassword());
        if(!checkuser){
            Boolean insert = DB.insertData(user);
            if(insert){
                isReg = true;
            }
        }
        return isReg;
    }

    // Метод для аутентификации пользователя
    public boolean authenticateUser(String email, String password) {
        Boolean checkuserpass = DB.checkname(email, password);
        if(checkuserpass){
            return true;
        }
        else{
            return false;
        }
    }
    public String[] getInfo(String email, String password){
        return DB.get_user_data(email, password);
    }
}
