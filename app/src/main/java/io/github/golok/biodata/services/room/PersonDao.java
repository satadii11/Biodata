package io.github.golok.biodata.services.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.github.golok.biodata.model.Person;
import io.reactivex.Single;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
@Dao
public interface PersonDao {
    @Query("SELECT * FROM Person")
    Single<List<Person>> findAllPersons();

    @Insert(onConflict = OnConflictStrategy.FAIL)
    long insertNewPerson(Person person);

    @Update
    int updateExistingPerson(Person person);

    @Delete
    int deleteExistingPerson(Person person);
}
