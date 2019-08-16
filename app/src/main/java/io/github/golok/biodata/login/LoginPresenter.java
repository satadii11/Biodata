package io.github.golok.biodata.login;

import android.annotation.SuppressLint;
import android.util.Log;

import io.github.golok.biodata.model.User;
import io.github.golok.biodata.repository.UserRepository;
import io.reactivex.functions.Consumer;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
class LoginPresenter implements LoginContract.Presenter {
    private UserRepository userRepository;
    private LoginContract.View view;

    LoginPresenter(UserRepository userRepository, LoginContract.View view) {
        this.userRepository = userRepository;
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void login(final String nim, final String password) {
        userRepository.findUserByNim(nim)
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        if (password.equals(user.getPassword())) onLoginSuccess(user.getNama());
                        else onLoginWrongPassword();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onLoginWrongNim(nim);
                    }
                });
    }

    private void onLoginSuccess(String name) {
        view.showMain(name);
    }

    private void onLoginWrongPassword() {
        view.showMessage("Password yang dimasukkan salah");
    }

    private void onLoginWrongNim(String nim) {
        view.showMessage(String.format("Pengguna dengan nim %s tidak ditemukan", nim));
    }
}
