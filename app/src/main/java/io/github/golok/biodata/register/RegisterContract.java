package io.github.golok.biodata.register;

public interface RegisterContract {
    interface View {
        void showMessage(String message);
        void showLogin();
    }

    interface Presenter {
        void register(String name, String nim, String password);
    }
}
