package io.github.golok.biodata.services.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import io.github.golok.biodata.model.User;
import io.reactivex.Single;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM User WHERE nim=:nim")
    Single<User> findUserByNim(String nim);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    long insertNewUser(User user);
}
