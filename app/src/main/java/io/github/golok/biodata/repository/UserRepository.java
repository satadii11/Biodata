package io.github.golok.biodata.repository;

import java.util.concurrent.Callable;

import io.github.golok.biodata.model.User;
import io.github.golok.biodata.services.room.UserDao;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class UserRepository {
    private static UserRepository instance;

    public static UserRepository getInstance(UserDao dao) {
        if (instance == null) {
            instance = new UserRepository(dao);
        }

        return instance;
    }

    private UserDao dao;

    private UserRepository(UserDao dao) {
        this.dao = dao;
    }

    public Single<Long> insertNewUser(String name, String nim, String password) {
        final User user = new User(nim, name, password);
        return Single
                .fromCallable(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return dao.insertNewUser(user);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<User> findUserByNim(String nim) {
        return dao.findUserByNim(nim)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
