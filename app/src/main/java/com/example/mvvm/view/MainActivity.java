package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        UserViewModel userViewModel=new UserViewModel(this);
        activityMainBinding.setUser(userViewModel);

    }
}
