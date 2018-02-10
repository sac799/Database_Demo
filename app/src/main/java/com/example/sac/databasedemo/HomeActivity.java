package com.example.sac.databasedemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    public Button button_AddEmployee,button_SearchEmployee, button_ViewAllDetails, button_DeleteAllData;
    private DBHelper dbHelper;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        button_AddEmployee = findViewById(R.id.btnAddEmployee);
        button_SearchEmployee = findViewById(R.id.btnSearchEmployee);
        button_ViewAllDetails = findViewById(R.id.btnShowEmployees);
        button_DeleteAllData = findViewById(R.id.btnDeleteData);




        button_AddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddEmployeeActivity.class);
                startActivity(intent);
            }
        });

        button_SearchEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SearchEmployeeActivity.class);
                startActivity(intent);
            }
        });

        button_ViewAllDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ShowAllActivity.class);
                startActivity(intent);

            }
        });

//        button_DeleteAllData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dbHelper.deleteAll();
//                Toast.makeText(HomeActivity.this,"All records deleted successfully...",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
