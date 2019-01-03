package com.example.cheshta.roomtest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface TryDao {

    @Insert
    void insertTry(Try t);

    @Query("SELECT * FROM Try")
    Try getTry();
}
