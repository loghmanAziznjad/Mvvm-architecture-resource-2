package com.example.mvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ItemUserBinding;
import com.example.mvvm.viewmodel.UserViewModel;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomHolder> {

    private ArrayList<UserViewModel> arrayList =new ArrayList<>();
    private LayoutInflater layoutInflater;

    public UserAdapter(ArrayList<UserViewModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null)
         layoutInflater=LayoutInflater.from(parent.getContext());

        ItemUserBinding userBinding= DataBindingUtil.inflate(layoutInflater, R.layout.item_user,parent,false);
        return new CustomHolder(userBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        UserViewModel userViewModel=arrayList.get(position);
        holder.bind(userViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomHolder extends RecyclerView.ViewHolder{



        private ItemUserBinding itemUserBinding;

        public CustomHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding=itemUserBinding;

        }

        private void bind(UserViewModel userViewModel){
            this.itemUserBinding.setItem(userViewModel);
            this.itemUserBinding.executePendingBindings();
        }

        public ItemUserBinding getItemUserBinding() {
            return itemUserBinding;
        }
    }

}
