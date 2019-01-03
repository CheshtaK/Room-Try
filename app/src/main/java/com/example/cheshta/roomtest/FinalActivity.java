package com.example.cheshta.roomtest;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {

    AppDatabase db;

    Try t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"try")
                .allowMainThreadQueries()
                .build();

        t = db.tryDao().getTry();

        Toast.makeText(this, "Finally "+t.getCounter(), Toast.LENGTH_SHORT).show();
    }
}
