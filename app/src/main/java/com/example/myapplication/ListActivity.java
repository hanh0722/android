package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.db.StudentDB;
import com.example.myapplication.model.Student;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        StudentDB studentdb = new StudentDB(this);
        ArrayList<Student> list = studentdb.get();

        ListView listView = (ListView) findViewById(R.id.list);

        ArrayList<String> payload = new ArrayList<>();

        for(Student i: list) {
            payload.add(i.getName());
        }
        ArrayAdapter<String> data = new ArrayAdapter<>(this, R.layout.list_item, R.id.name, payload);
        listView.setAdapter(data);


    }
}