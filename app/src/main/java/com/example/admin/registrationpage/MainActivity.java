package com.example.admin.registrationpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b,r;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.btn1);
        r=(Button)findViewById(R.id.btn2);
        e1=(EditText) findViewById(R.id.et1);
        e2=(EditText) findViewById(R.id.et2);
        e3=(EditText) findViewById(R.id.et3);
        e4=(EditText) findViewById(R.id.et4);
        e5=(EditText) findViewById(R.id.et5);
        e6=(EditText) findViewById(R.id.et6);
        e7=(EditText) findViewById(R.id.et7);
        e8=(EditText) findViewById(R.id.et8);
        e9=(EditText) findViewById(R.id.et9);
        e9=(EditText) findViewById(R.id.et10);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e= e1.getText().toString();




                  {

                }



            }
        });

    }
}
