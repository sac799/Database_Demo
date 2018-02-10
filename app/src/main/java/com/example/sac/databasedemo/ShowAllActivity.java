package com.example.sac.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ShowAllActivity extends AppCompatActivity {

    RecyclerView showAllData;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show_all);

        showAllData = findViewById(R.id.recyclerShowAllDetails);
        dbHelper = new DBHelper(this);
        List<Employee> employeeList = dbHelper.showAllEmployee();
        RecyclerAdapter listAdapter = new RecyclerAdapter(this, employeeList);
        showAllData.setLayoutManager(new LinearLayoutManager(this));
        showAllData.setAdapter(listAdapter);

    }
}
