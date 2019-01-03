package com.example.cheshta.roomtest;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int counter;
    AppDatabase db;

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"try")
                .allowMainThreadQueries()
                .build();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(db.tryDao().getTry() != null){
                    counter = db.tryDao().getTry().getCounter();
                }

                counter += 1;
                Try t = new Try(1, counter);

                db.tryDao().insertTry(t);
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }
}
