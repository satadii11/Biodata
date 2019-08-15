package io.github.golok.biodata.register;

import android.annotation.SuppressLint;

import io.github.golok.biodata.repository.UserRepository;
import io.reactivex.functions.Consumer;

class RegisterPresenter implements RegisterContract.Presenter {
    private UserRepository userRepository;
    private RegisterContract.View view;

    RegisterPresenter(RegisterContract.View view, UserRepository userRepository) {
        this.view = view;
        this.userRepository = userRepository;
    }

    @SuppressLint("CheckResult")
    @Override
    public void register(String name, String nim, String password) {
        final String finalNim = nim;
        userRepository.insertNewUser(name, nim, password)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (aLong != -1) onRegisterSuccess();
                        else onRegisterFailed(finalNim);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onRegisterFailed(finalNim);
                    }
                });
    }

    private void onRegisterSuccess() {
        view.showMessage("Sukses melakukan registrasi pengguna baru");
        view.showLogin();
    }

    private void onRegisterFailed(String nim) {
        view.showMessage(String.format("NIM %s sudah terdaftar", nim));
    }
}
