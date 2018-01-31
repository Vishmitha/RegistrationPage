package com.example.admin.registrationpage;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button b, r;
    EditText Firstname, Middelname, Lastname, Email, Password, ConfirmPassword, Phno, Faxno, Address;
    TextView DOB;
    Validation validation;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    User user;

    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.btn1);
        r = (Button) findViewById(R.id.btn2);
        Firstname = (EditText) findViewById(R.id.et1);
        Middelname = (EditText) findViewById(R.id.et2);
        Lastname = (EditText) findViewById(R.id.et3);
        dateView = (TextView) findViewById(R.id.textView3);
        Email = (EditText) findViewById(R.id.et4);
        Password = (EditText) findViewById(R.id.et5);
        ConfirmPassword = (EditText) findViewById(R.id.et6);
        Phno = (EditText) findViewById(R.id.et7);
        Faxno = (EditText) findViewById(R.id.et8);
        DOB = (TextView) findViewById(R.id.tv1);
        Address = (EditText) findViewById(R.id.et10);

        user = new User();
        dataBase = new DataBase(this);
        validation = new Validation();

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UsersListActivity.class);
                startActivity(intent);
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (validation.isValidName(Firstname.getText().toString())) {
                    Firstname.setError("please enter a name it contain less than 11 charater");
                } else {
                    Firstname.setError(null);
                }

                if (!validation.isValidName(Middelname.getText().toString())) {
                    Middelname.setError("please enter Middle name");
                } else {
                    Middelname.setError(null);
                }

                if (!validation.isValidName(Lastname.getText().toString())) {
                    Lastname.setError("please enter Last name");
                } else {
                    Lastname.setError(null);
                }


                if (!validation.isValidEmail(Email.getText().toString())) {
                    Email.setError("please enter valid email it should be this formate abc@xyz.com");
                } else {
                    Email.setError(null);
                }

              /*  if (!validation.isValidPassword(Password.getText().toString())) {
                    Password.setError("A password must be eight characters including one uppercase letter, one special character and alphanumeric characters");
                } else {
                    Password.setError(null);
                }*/
              /*  if (!validation.isValidPassword(ConfirmPassword.getText().toString())) {
                    ConfirmPassword.setError("plz enter correct password");
                } else {
                    ConfirmPassword.setError(null);
                }*/

                if (!validation.isValidNumber(Phno.getText().toString())) {
                    Phno.setError("It should consist of 10 digits ");
                } else {
                    Phno.setError(null);
                }

                if (!validation.isValidFaxno(Faxno.getText().toString())) {
                    Faxno.setError("It should consist of 14 digits ");
                } else {
                    Faxno.setError(null);
                }


                if (!validation.isValidAddress(Address.getText().toString())) {
                    Address.setError("plz entere address");
                } else {
                    Address.setError(null);
                }


                postDataToSQLite();


            }


        });


        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "",
        //Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    private void postDataToSQLite() {


        user.setFname(Firstname.getText().toString().trim());
        user.setMname(Middelname.getText().toString().trim());
        user.setLname(Lastname.getText().toString().trim());
        user.setEmail(Email.getText().toString().trim());
        user.setPassword(Password.getText().toString().trim());
        user.setPhno(Phno.getText().toString().trim());
        user.setFaxno(Faxno.getText().toString().trim());
        user.setDOB(DOB.getText().toString().trim());
        user.setAddress(Address.getText().toString().trim());

        dataBase.addUser(user);
     //   Toast.makeText(getApplicationContext(), "Data is inserted in Table", Toast.LENGTH_LONG).show();


    }


}
