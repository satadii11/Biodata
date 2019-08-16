package io.github.golok.biodata.login;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public interface LoginContract {
    interface View {
        void showMain(String name);
        void showMessage(String message);
    }

    interface Presenter {
        void login(String nim, String password);
    }
}
