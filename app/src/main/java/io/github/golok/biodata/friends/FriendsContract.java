package io.github.golok.biodata.friends;

import java.util.List;

import io.github.golok.biodata.common.BasePresenter;
import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public interface FriendsContract {
    interface View {
        void setFriends(List<Person> friends);
        void showAddFriend();
    }

    interface Presenter extends BasePresenter {
        void addFriend();
    }
}
