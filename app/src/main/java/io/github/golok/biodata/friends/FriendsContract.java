package io.github.golok.biodata.friends;

import java.util.ArrayList;

import io.github.golok.biodata.common.BasePresenter;
import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public interface FriendsContract {
    interface View {
        void setFriends(ArrayList<Person> friends);
        void showAddFriend();
        void updateFriends();
    }

    interface Presenter extends BasePresenter {
        void addFriend();
        void resume();
    }
}
