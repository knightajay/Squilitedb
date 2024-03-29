package com.example.squilitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dbhandler handler= new Dbhandler(this,"empdb" , null, 1);
//handler.addEmployee(new Employ(10,"ajay" , 33.3));
handler.getEmploye(3);
handler.close();
    }

}