package io.github.golok.biodata.profile;

import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class ProfilePresenter implements ProfileContract.Presenter {
    private Person me;
    private ProfileContract.View view;

    ProfilePresenter(Person me, ProfileContract.View view) {
        this.me = me;
        this.view = view;
    }

    @Override
    public void start() {
        view.showBirthday(me.getBirthDay());
        view.showPhoto(me.getFoto());
        view.showName(me.getNama());
        view.showNim(me.getNim());
        view.showDescription(me.getDeskripsi());
        view.showClass(me.getKelas());
    }
}
