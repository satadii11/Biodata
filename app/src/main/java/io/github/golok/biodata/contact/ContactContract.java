package io.github.golok.biodata.contact;

import io.github.golok.biodata.common.BasePresenter;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public interface ContactContract {
    interface View {
        void showEmail(String email);
        void showPhone(String phone);
        void showInstagram(String instagram);
        void showFacebook(String facebook);
        void showLinkedin(String linkedin);
        void showGithub(String github);
        void openEmailApps(String email);
        void openPhone(String phone);
        void openInstagram(String instagram);
        void openFacebook(String facebook);
        void openLinkedin(String linkedin);
        void openGithub(String github);
    }

    interface Presenter extends BasePresenter {
        void onEmailClicked();
        void onPhoneClicked();
        void onFacebookClicked();
        void onInstagramClicked();
        void onLinkedinClicked();
        void onGithubClicked();
    }
}
