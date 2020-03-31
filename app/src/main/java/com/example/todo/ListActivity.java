package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.d("tag","686769message");
        ListView lv = (ListView) findViewById(R.id.lvTask);
        ArrayList<String> tasksFromDb = new ArrayList<>();
        DBHelper myDb = new DBHelper(this);
        Cursor data  = myDb.getData();
        while(data.moveToNext()){
            tasksFromDb.add(data.getString(1));
        }
        ArrayAdapter bind = new ArrayAdapter(this,R.layout.task,R.id.lvTask,tasksFromDb);
        lv.setAdapter(bind);
    }
}
