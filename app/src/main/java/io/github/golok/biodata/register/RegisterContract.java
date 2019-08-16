package io.github.golok.biodata.register;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public interface RegisterContract {
    interface View {
        void showMessage(String message);
        void showLogin();
    }

    interface Presenter {
        void register(String name, String nim, String password);
    }
}
