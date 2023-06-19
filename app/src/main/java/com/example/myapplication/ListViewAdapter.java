package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Student> {

    private Context context;
    private ArrayList<Student> list;
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }
}
