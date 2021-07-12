package com.ivanhintoro182101942.userscrud.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.ivanhintoro182101942.userscrud.EditActivity;
import com.ivanhintoro182101942.userscrud.R;
import com.ivanhintoro182101942.userscrud.model.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {
    List<User> mUserList;

    public UsersAdapter(List<User> userList){
        mUserList=userList;
    }

    @NonNull
    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.MyViewHolder holder, int position) {
        holder.mTextViewId.setText("Id = "+mUserList.get(position).getId());
        holder.mTextViewEmail.setText("Email = "+mUserList.get(position).getEmail());
        holder.mTextViewFirstName.setText("First Name = "+mUserList.get(position).getFirst_name());
        holder.mTextViewLastName.setText("Last Name = "+mUserList.get(position).getLast_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id",mUserList.get(position).getId());
                mIntent.putExtra("Email",mUserList.get(position).getEmail());
                mIntent.putExtra("First Name",mUserList.get(position).getFirst_name());
                mIntent.putExtra("Last Name",mUserList.get(position).getLast_name());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewName, mTextViewEmail, mTextViewFirstName, mTextViewLastName;

        public MyViewHolder(View itemView){
            super(itemView);
            mTextViewId = (TextView)itemView.findViewById(R.id.tvId);
            mTextViewEmail = (TextView)itemView.findViewById(R.id.tvEmail);
            mTextViewFirstName = (TextView)itemView.findViewById(R.id.tvFirstName);
            mTextViewLastName = (TextView)itemView.findViewById(R.id.tvLastName);
        }
    }
}
