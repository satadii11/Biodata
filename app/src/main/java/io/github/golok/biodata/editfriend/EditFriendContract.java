package io.github.golok.biodata.editfriend;

import io.github.golok.biodata.common.BasePresenter;
import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public interface EditFriendContract {
    interface View {
        void showMessage(String message);
        void showDetail(Person person);
        void showName(String name);
        void showNim(String nim);
        void showClass(String kelas);
        void showEmail(String email);
        void showPhone(String phone);
        void showInstagram(String instagram);
    }

    interface Presenter extends BasePresenter {
        void save(Person person);
    }
}
