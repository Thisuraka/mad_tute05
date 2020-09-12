package com.example.tute05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tute05.Database.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etUserName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.editText1);
        etPassword = findViewById(R.id.editText2);
    }

    public void addData(View view){
        DBHelper dbHelper = new DBHelper(this);

        long val = dbHelper.addInfo(etUserName.getText().toString(), etPassword.getText().toString());

        if(val>0){
            Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Insertion failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void viewAll(View view){
        DBHelper dbHelper = new DBHelper(this);

        List uNames = dbHelper.readAllInfo();

        Toast.makeText(this, uNames.toString(), Toast.LENGTH_SHORT).show();

    }

}