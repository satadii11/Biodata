package io.github.golok.biodata.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.services.room.PersonDao;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class FriendRepository {
    private static FriendRepository instance;

    public static FriendRepository getInstance(PersonDao dao) {
        if (instance == null) {
            instance = new FriendRepository(dao);
        }

        return instance;
    }

    private PersonDao dao;

    private FriendRepository(PersonDao dao) {
        this.dao = dao;
    }

    public Single<Long> addFriend(final Person friend) {
        return Single
                .fromCallable(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return dao.insertNewPerson(friend);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Integer> removeFriend(final Person friend) {
        return Single
                .fromCallable(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return dao.deleteExistingPerson(friend);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Integer> updateFriend(final Person friend) {
        return Single
                .fromCallable(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return dao.updateExistingPerson(friend);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<Person>> getFriends() {
        return dao.findAllPersons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
