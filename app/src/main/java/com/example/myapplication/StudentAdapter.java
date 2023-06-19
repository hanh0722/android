package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.model.Student;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context ctx;
    private ArrayList<Student> list;
    public StudentAdapter(@NonNull Context context,  @NonNull ArrayList<Student> objects) {
        super(context, R.layout.list_item_object, objects);
        this.ctx = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(this.ctx).inflate(R.layout.list_item_object, parent, false);
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView age = (TextView) v.findViewById(R.id.age);

        name.setText(list.get(position).getName());
        age.setText(list.get(position).getAge());

        return v;
    }
}
