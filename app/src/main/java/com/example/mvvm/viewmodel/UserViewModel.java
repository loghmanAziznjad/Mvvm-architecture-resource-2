package com.example.mvvm.viewmodel;

import android.content.Context;
import android.widget.RelativeLayout;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mvvm.BR;
import com.example.mvvm.model.User;
import com.example.mvvm.view.adapter.UserAdapter;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable {

    private ArrayList<UserViewModel> arrayListMutableLiveData= new ArrayList<>();

    private String name;
    private String phone;
    private Context context;

    public UserViewModel(Context context) {
        this.context = context;

        for (int i =1; i<=10; i++){
            User user=new User("item :"+i,"0914-------");
            UserViewModel userViewModel = new UserViewModel(user);
            arrayListMutableLiveData.add(userViewModel);
        }

    }

    public UserViewModel(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
    }



    @BindingAdapter("bind:recyclerUser")
    public static void recyclerViewBinder(final RecyclerView recyclerView, final ArrayList<UserViewModel> arrayListMutableLiveData){
                UserAdapter userAdapter = new UserAdapter(arrayListMutableLiveData);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(userAdapter);
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


    public void setArrayListMutableLiveData(ArrayList<UserViewModel> arrayListMutableLiveData) {
        this.arrayListMutableLiveData = arrayListMutableLiveData;
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    public ArrayList<UserViewModel> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }
}
