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
        holder.textViewFName.setText(listUsers.get(position).getFname());
        holder.textViewMName.setText(listUsers.get(position).getMname());
        holder.textViewLName.setText(listUsers.get(position).getLname());
        holder.textViewEmail.setText(listUsers.get(position).getEmail());
        holder.textViewPassword.setText(listUsers.get(position).getPassword());
        holder.textViewPhono.setText(listUsers.get(position).getPhno());
        holder.textViewFaxno.setText(listUsers.get(position).getFaxno());
        holder.textViewDoB.setText(listUsers.get(position).getDOB());
        holder.textViewAddress.setText(listUsers.get(position).getAddress());
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

        public TextView textViewFName;
        public TextView textViewMName;
        public TextView textViewLName;
        public TextView textViewEmail;
        public TextView textViewPassword;
        public TextView textViewPhono;
        public TextView textViewFaxno;
        public TextView textViewDoB;
        public TextView textViewAddress;

        public UserViewHolder(View view) {
            super(view);
            textViewFName = (TextView) view.findViewById(R.id.Fname);
            textViewMName = (TextView) view.findViewById(R.id.Mname);
            textViewLName= (TextView) view.findViewById(R.id.Lname);
            textViewEmail = (TextView) view.findViewById(R.id.Email);
            textViewPassword = (TextView) view.findViewById(R.id.Password);
            textViewPhono = (TextView) view.findViewById(R.id.Phono);
            textViewFaxno = (TextView) view.findViewById(R.id.Faxno);
            textViewDoB = (TextView) view.findViewById(R.id.DoB);
            textViewAddress = (TextView) view.findViewById(R.id.Address);
        }
    }


}