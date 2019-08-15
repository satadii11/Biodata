package io.github.golok.biodata.frienddetail;

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
public class FriendDetailPresenter implements FriendDetailContract.Presenter {
    private FriendRepository friendRepository;
    private FriendDetailContract.View view;
    private Person friend;

    public FriendDetailPresenter(FriendRepository friendRepository, FriendDetailContract.View view,
                                 Person friend) {
        this.friendRepository = friendRepository;
        this.view = view;
        this.friend = friend;
    }

    @Override
    public void start() {
        view.showEmail(friend.getEmail());
        view.showInstragram(friend.getInstagram());
        view.showKelas(friend.getKelas());
        view.showName(friend.getNama());
        view.showNim(friend.getNim());
        view.showPhone(friend.getPhone());
    }

    @Override
    public void onPhoneClicked() {
        view.openPhoneApps(friend.getPhone());
    }

    @Override
    public void onInstagramClicked() {
        view.openInstagram(friend.getInstagram());
    }

    @Override
    public void onEmailClicked() {
        view.openEmailApps(friend.getEmail());
    }

    @Override
    public void onDeleteClicked() {
        view.openDialog();
    }

    @SuppressLint("CheckResult")
    @Override
    public void delete() {
        friendRepository.removeFriend(friend)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        onDeleteFriendSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }

    @Override
    public void edit() {
        view.showEditForm(friend);
    }

    private void onDeleteFriendSuccess() {
        view.showMessage("Success deleting a friend");
        view.showMainActivity();
    }
}
