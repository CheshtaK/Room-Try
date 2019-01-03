package com.example.cheshta.roomtest;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.cheshta.roomtest.MainActivity.counter;

public class Main3Activity extends AppCompatActivity {

    AppDatabase db;

    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn3 = findViewById(R.id.btn3);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"try")
                .allowMainThreadQueries()
                .build();

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter += 1;
                Try t = new Try(1, counter);

                db.tryDao().insertTry(t);
                startActivity(new Intent(Main3Activity.this, FinalActivity.class));
            }
        });
    }
}
