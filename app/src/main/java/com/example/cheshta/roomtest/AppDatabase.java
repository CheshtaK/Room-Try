package com.example.cheshta.roomtest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Try.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TryDao tryDao();
}
