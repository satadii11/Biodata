package io.github.golok.biodata.login;

public interface LoginContract {
    interface View {
        void showMain(String name);
        void showMessage(String message);
    }

    interface Presenter {
        void login(String nim, String password);
    }
}
