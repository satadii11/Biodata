package io.github.golok.biodata.friends;

import io.github.golok.biodata.repository.FriendRepository;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class FriendsPresenter implements FriendsContract.Presenter {
    private FriendRepository friendRepository;
    private FriendsContract.View view;

    FriendsPresenter(FriendsContract.View view) {
        friendRepository = FriendRepository.getInstance();
        this.view = view;
    }

    @Override
    public void start() {
        view.setFriends(friendRepository.getFriends());
    }

    @Override
    public void addFriend() {
        view.showAddFriend();
    }

    @Override
    public void resume() {
        view.updateFriends();
    }
}
