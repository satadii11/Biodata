package io.github.golok.biodata.services.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.model.User;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
@Database(entities = {User.class, Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "biodata.sqlite").build();
        }

        return instance;
    }

    public abstract UserDao userDao();
    public abstract PersonDao personDao();
}
