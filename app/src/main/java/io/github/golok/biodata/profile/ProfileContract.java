package io.github.golok.biodata.profile;

import io.github.golok.biodata.common.BasePresenter;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Selasa, 21 Mei 2019
 */
public interface ProfileContract {
    interface View {
        void showPhoto(int photoId);
        void showName(String name);
        void showDescription(String desc);
        void showNim(String nim);
        void showBirthday(String birthday);
    }

    interface Presenter extends BasePresenter {
    }
}
