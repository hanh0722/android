package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.db.StudentDB;
import com.example.myapplication.model.Student;

import java.util.ArrayList;

public class ListObject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_object);

        StudentDB db = new StudentDB(this);
        ArrayList<Student> list = db.get();

        ListView listView = (ListView) findViewById(R.id.list_view);
        StudentAdapter adapter = new StudentAdapter(this, list);

        listView.setAdapter(adapter);
    }
}