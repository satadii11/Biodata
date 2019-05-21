package io.github.golok.biodata.frienddetail;

import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.repository.FriendRepository;

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

    FriendDetailPresenter(FriendDetailContract.View view, Person friend) {
        friendRepository = FriendRepository.getInstance();
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

    @Override
    public void delete() {
        friendRepository.removeFriend(friend);
        view.showMessage("Success deleting a friend");
        view.showMainActivity();
    }

    @Override
    public void edit() {
        view.showEditForm(friend);
    }
}
