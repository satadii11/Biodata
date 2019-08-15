package io.github.golok.biodata.friends;

import android.annotation.SuppressLint;

import java.util.List;

import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.repository.FriendRepository;
import io.reactivex.functions.Consumer;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class FriendsPresenter implements FriendsContract.Presenter {
    private FriendRepository friendRepository;
    private FriendsContract.View view;

    FriendsPresenter(FriendRepository friendRepository, FriendsContract.View view) {
        this.friendRepository = friendRepository;
        this.view = view;
    }


    @SuppressLint("CheckResult")
    @Override
    public void start() {
        friendRepository.getFriends()
                .subscribe(new Consumer<List<Person>>() {
                    @Override
                    public void accept(List<Person> people) throws Exception {
                        onSuccessFindAllFriend(people);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }

    @Override
    public void addFriend() {
        view.showAddFriend();
    }

    private void onSuccessFindAllFriend(List<Person> people) {
        view.setFriends(people);
    }
}
