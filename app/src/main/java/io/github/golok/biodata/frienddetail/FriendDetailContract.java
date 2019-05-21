package io.github.golok.biodata.frienddetail;

import io.github.golok.biodata.common.BasePresenter;
import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public interface FriendDetailContract {
    interface View {
        void showMessage(String message);
        void showName(String name);
        void showNim(String nim);
        void showKelas(String kelas);
        void showEmail(String email);
        void showPhone(String phone);
        void showInstragram(String instagram);
        void showMainActivity();
        void showEditForm(Person person);
        void openInstagram(String instagram);
        void openPhoneApps(String phone);
        void openEmailApps(String email);
        void openDialog();
    }

    interface Presenter extends BasePresenter {
        void onPhoneClicked();
        void onInstagramClicked();
        void onEmailClicked();
        void onDeleteClicked();
        void delete();
        void edit();
    }
}
