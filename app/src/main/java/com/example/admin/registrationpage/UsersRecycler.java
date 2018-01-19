package com.example.admin.registrationpage;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by User on 1/18/2018.
 */

public class UsersRecycler extends RecyclerView.Adapter<UsersRecycler.UserViewHolder> {

    private List<User> listUsers;

    public UsersRecycler(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewName.setText(listUsers.get(position).getFname());
        holder.textViewName.setText(listUsers.get(position).getFname());
        holder.textViewName.setText(listUsers.get(position).getFname());
        holder.textViewEmail.setText(listUsers.get(position).getEmail());
        holder.textViewPassword.setText(listUsers.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        Log.v(UsersRecycler.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewEmail;
        public TextView textViewPassword;

        public UserViewHolder(View view) {
            super(view);
            textViewName = (TextView) view.findViewById(R.id.Fname);
            textViewEmail = (TextView) view.findViewById(R.id.Mname);
            textViewPassword = (TextView) view.findViewById(R.id.Lname);
            textViewName = (TextView) view.findViewById(R.id.Email);
            textViewEmail = (TextView) view.findViewById(R.id.Password);
            textViewPassword = (TextView) view.findViewById(R.id.Phono);
            textViewName = (TextView) view.findViewById(R.id.Faxno);
            textViewEmail = (TextView) view.findViewById(R.id.DoB);
            textViewPassword = (TextView) view.findViewById(R.id.Address);
        }
    }


}