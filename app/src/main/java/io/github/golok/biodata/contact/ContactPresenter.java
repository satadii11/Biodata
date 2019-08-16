package io.github.golok.biodata.contact;

import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class ContactPresenter implements ContactContract.Presenter {
    private ContactContract.View view;
    private Person me;

    ContactPresenter(ContactContract.View view, Person me) {
        this.view = view;
        this.me = me;
    }

    @Override
    public void start() {
        view.showEmail(me.getEmail());
        view.showFacebook(me.getFacebook());
        view.showGithub(me.getGithub());
        view.showInstagram(me.getInstagram());
        view.showLinkedin(me.getLinkedin());
        view.showPhone(me.getPhone());
    }

    @Override
    public void onEmailClicked() {
        view.openEmailApps(me.getEmail());
    }

    @Override
    public void onPhoneClicked() {
        view.openPhone(me.getPhone());
    }

    @Override
    public void onFacebookClicked() {
        view.openFacebook(me.getFacebook());
    }

    @Override
    public void onInstagramClicked() {
        view.openInstagram(me.getInstagram());
    }

    @Override
    public void onLinkedinClicked() {
        view.openLinkedin(me.getLinkedin());
    }

    @Override
    public void onGithubClicked() {
        view.openGithub(me.getGithub());
    }
}
