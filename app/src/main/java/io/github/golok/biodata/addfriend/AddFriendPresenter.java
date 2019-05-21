package io.github.golok.biodata.addfriend;

import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.repository.FriendRepository;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class AddFriendPresenter implements AddFriendContract.Presenter {
    private FriendRepository friendRepository;
    private AddFriendContract.View view;

    AddFriendPresenter(AddFriendContract.View view) {
        friendRepository = FriendRepository.getInstance();
        this.view = view;
    }

    @Override
    public void save(Person person) {
        friendRepository.addFriend(person);
        view.showMessage("Success adding new friend");
        view.showDetail(person);
    }

    @Override
    public void start() {
    }
}
