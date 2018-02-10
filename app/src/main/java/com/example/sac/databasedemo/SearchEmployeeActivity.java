package com.example.sac.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchEmployeeActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText editText_SearchName, editText_EmployeeName, editText_EmployeeAddress, editText_EmployeeSalary, editText_EmployeePhone;
    Button button_Search;
    TextView textView_Name,textView_Address, textView_Phone, textView_Salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        dbHelper = new DBHelper(this);

        editText_SearchName = findViewById(R.id.edtEmployeeNameSearch);
        editText_EmployeeName = findViewById(R.id.edtEmployeeName);
        editText_EmployeeAddress = findViewById(R.id.edtEmployeeAddress);
        editText_EmployeeSalary = findViewById(R.id.edtEmployeeSalary);
        editText_EmployeePhone = findViewById(R.id.edtEmployeePhone);
        button_Search = findViewById(R.id.btnSearch);
        textView_Name = findViewById(R.id.txtName);
        textView_Address = findViewById(R.id.txtAddress);
        textView_Phone = findViewById(R.id.txtPhone);
        textView_Salary = findViewById(R.id.txtSalary);

        textView_Name.setVisibility(View.GONE);
        textView_Address.setVisibility(View.GONE);
        textView_Phone.setVisibility(View.GONE);
        textView_Salary.setVisibility(View.GONE);
        editText_EmployeeName.setVisibility(View.GONE);
        editText_EmployeeAddress.setVisibility(View.GONE);
        editText_EmployeeSalary.setVisibility(View.GONE);
        editText_EmployeePhone.setVisibility(View.GONE);

        button_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText_SearchName.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Please enter name to search", Toast.LENGTH_SHORT).show();
                } else {
                    Employee employee = dbHelper.searchEmployee(name);
                    if (employee == null) {
                        textView_Name.setVisibility(View.GONE);
                        textView_Address.setVisibility(View.GONE);
                        textView_Phone.setVisibility(View.GONE);
                        textView_Salary.setVisibility(View.GONE);
                        editText_EmployeeName.setVisibility(View.GONE);
                        editText_EmployeeAddress.setVisibility(View.GONE);
                        editText_EmployeeSalary.setVisibility(View.GONE);
                        editText_EmployeePhone.setVisibility(View.GONE);
                        String strEmployeeNameSearch = editText_SearchName.getText().toString().trim();
                        Toast.makeText(getApplicationContext(), "No employee found with this name: " +strEmployeeNameSearch+ "", Toast.LENGTH_SHORT).show();
                    } else {
                        textView_Name.setVisibility(View.VISIBLE);
                        textView_Address.setVisibility(View.VISIBLE);
                        textView_Phone.setVisibility(View.VISIBLE);
                        textView_Salary.setVisibility(View.VISIBLE);
                        editText_EmployeeName.setVisibility(View.VISIBLE);
                        editText_EmployeeAddress.setVisibility(View.VISIBLE);
                        editText_EmployeeSalary.setVisibility(View.VISIBLE);
                        editText_EmployeePhone.setVisibility(View.VISIBLE);

                        editText_EmployeeName.setText(employee.empName);
                        editText_EmployeeAddress.setText(employee.empAddress);
                        editText_EmployeePhone.setText(employee.empPhone);
                        editText_EmployeeSalary.setText(String.valueOf(employee.empSalary));
                    }
                }

            }
        });
    }
}
