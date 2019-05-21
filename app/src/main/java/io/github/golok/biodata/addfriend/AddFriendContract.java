package io.github.golok.biodata.addfriend;

import io.github.golok.biodata.common.BasePresenter;
import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public interface AddFriendContract {
    interface View {
        void showMessage(String message);
        void showDetail(Person person);
    }

    interface Presenter extends BasePresenter {
        void save(Person person);
    }
}
