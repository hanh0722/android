package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLE_NAME = "student";
    public StudentDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlString = "CREATE TABLE " + DATABASE_TABLE_NAME + "( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name VARCHAR(100) NOT NULL, " +
                "age INTEGER NOT NULL " +
                ")";

        sqLiteDatabase.execSQL(sqlString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("name", student.getName());
        content.put("age", student.getAge());

        long result = db.insert(DATABASE_TABLE_NAME, "id", content);
        System.out.println(result);
    }

    public ArrayList<Student> get() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor query = db.query(DATABASE_TABLE_NAME, null, null, null, null, null, null, null);
        ArrayList<Student> list = new ArrayList<>();
        if (query != null) {
            query.moveToNext();
            while(!query.isAfterLast()) {
                list.add(new Student(query.getString(1), query.getInt(2)));
                query.moveToNext();
            }
        }
        return list;

    }
}
