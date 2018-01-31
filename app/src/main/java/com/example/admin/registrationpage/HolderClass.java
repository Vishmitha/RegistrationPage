package com.example.admin.registrationpage;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.List;


/**
 * Created by User on 1/18/2018.
 */

public class HolderClass extends RecyclerView.Adapter<HolderClass.UserViewHolder> {

    private List<User> listUsers;

    public HolderClass(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem, parent, false);

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
        Log.v(HolderClass.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }




    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewFName;
        public AppCompatTextView textViewMName;
        public AppCompatTextView textViewLName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewPassword;
        public AppCompatTextView textViewPhono;
        public AppCompatTextView textViewFaxno;
        public AppCompatTextView textViewDoB;
        public AppCompatTextView textViewAddress;

        public UserViewHolder(View view) {
            super(view);
            textViewFName = (AppCompatTextView) view.findViewById(R.id.textViewFName);
            textViewMName = (AppCompatTextView) view.findViewById(R.id.textViewMName);
            textViewLName= (AppCompatTextView) view.findViewById(R.id.textViewLName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);
            textViewPhono = (AppCompatTextView) view.findViewById(R.id.textViewPhono);
            textViewFaxno = (AppCompatTextView) view.findViewById(R.id.textViewFaxno);
            textViewDoB = (AppCompatTextView) view.findViewById(R.id.textViewDOB);
            textViewAddress = (AppCompatTextView) view.findViewById(R.id.textViewAddress);
        }
    }


}