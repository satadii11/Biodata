package io.github.golok.biodata.addfriend;

import android.annotation.SuppressLint;

import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.repository.FriendRepository;
import io.reactivex.functions.Consumer;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class AddFriendPresenter implements AddFriendContract.Presenter {
    private FriendRepository friendRepository;
    private AddFriendContract.View view;

    AddFriendPresenter(FriendRepository friendRepository, AddFriendContract.View view) {
        this.friendRepository = friendRepository;
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void save(final Person person) {
        friendRepository.addFriend(person)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (aLong != -1) onAddPersonSuccess(person);
                        else onAddPersonFailed(person.getNim());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onAddPersonFailed(person.getNim());
                    }
                });
    }

    private void onAddPersonSuccess(Person person) {
        view.showMessage("Success adding new friend");
        view.showDetail(person);
    }

    private void onAddPersonFailed(String nim) {
        view.showMessage(String.format("NIM %s sudah terdaftar", nim));
    }
}
