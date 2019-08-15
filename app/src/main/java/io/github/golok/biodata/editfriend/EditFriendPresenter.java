package io.github.golok.biodata.editfriend;

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
public class EditFriendPresenter implements EditFriendContract.Presenter {
    private FriendRepository friendRepository;
    private Person friend;
    private EditFriendContract.View view;

    EditFriendPresenter(FriendRepository friendRepository, Person friend,
                               EditFriendContract.View view) {
        this.friendRepository = friendRepository;
        this.friend = friend;
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void save(final Person person) {
        friendRepository.updateFriend(person)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        onEditFriendSuccess(person);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
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

    private void onEditFriendSuccess(Person person) {
        view.showMessage("Success editing a friend");
        view.showDetail(person);
    }
}
