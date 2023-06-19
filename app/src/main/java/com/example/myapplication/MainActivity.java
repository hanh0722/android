package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.db.StudentDB;
import com.example.myapplication.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context self = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentDB db = new StudentDB(getApplicationContext());
        ArrayList<Student> data = db.get();
        System.out.println(data.get(0).getName());

        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textName = (EditText) findViewById(R.id.name);
                String name = textName.getText().toString();

                EditText ageInput = (EditText) findViewById(R.id.age);
                Integer age = Integer.parseInt(ageInput.getText().toString());
                db.insert(new Student(name, age));
            }
        });

        Button buttonWatch = (Button) findViewById(R.id.watch);

        buttonWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });

        Button buttonWatchObject = (Button) findViewById(R.id.watch_object);

        buttonWatchObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListObject.class);
                startActivity(intent);
            }
        });
    }
}