package com.example.mvvm.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


import com.example.mvvm.BR;
import com.example.mvvm.model.User;

public class UserViewModel extends BaseObservable {

    private String name;
    private String phone;
    private Context context;

    public UserViewModel(Context context) {
        this.context = context;
    }

    public UserViewModel(User user) {
        this.name = name;
        this.phone = phone;
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR._all);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
