package io.github.golok.biodata.addfriend;

import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public interface AddFriendContract {
    interface View {
        void showMessage(String message);
        void showDetail(Person person);
    }

    interface Presenter {
        void save(Person person);
    }
}
