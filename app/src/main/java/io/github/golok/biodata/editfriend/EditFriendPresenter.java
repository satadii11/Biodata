package io.github.golok.biodata.editfriend;

import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.repository.FriendRepository;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class EditFriendPresenter implements EditFriendContract.Presenter {
    private FriendRepository friendRepository;
    private Person friend;
    private EditFriendContract.View view;

    EditFriendPresenter(Person friend, EditFriendContract.View view) {
        friendRepository = FriendRepository.getInstance();
        this.friend = friend;
        this.view = view;
    }

    @Override
    public void save(Person person) {
        friendRepository.updateFriend(friend, person);
        view.showMessage("Success editing new friend");
        view.showDetail(person);
    }

    @Override
    public void start() {
        view.showName(friend.getNama());
        view.showNim(friend.getNim());
        view.showClass(friend.getKelas());
        view.showPhone(friend.getPhone());
        view.showEmail(friend.getEmail());
        view.showInstagram(friend.getInstagram());
    }
}
