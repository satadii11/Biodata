package io.github.golok.biodata.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseFragment;
import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.utils.TextViewUtil;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class ContactFragment extends BaseFragment implements ContactContract.View {

    private ContactContract.Presenter presenter;

    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvInstagram;
    private TextView tvFacebook;
    private TextView tvGithub;
    private TextView tvLinkedin;
    private Toolbar tbContact;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        tvEmail = view.findViewById(R.id.tv_contact_email);
        tvPhone = view.findViewById(R.id.tv_contact_phone);
        tvInstagram = view.findViewById(R.id.tv_contact_instagram);
        tvFacebook = view.findViewById(R.id.tv_contact_facebook);
        tvGithub = view.findViewById(R.id.tv_contact_github);
        tvLinkedin = view.findViewById(R.id.tv_contact_linkedin);
        tbContact = view.findViewById(R.id.tb_contact);

        tbContact.inflateMenu(R.menu.menu_main);
        tbContact.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.menu_logout) {
                    logout();
                    return true;
                }

                return false;
            }
        });

        TextViewUtil.underline(tvEmail);
        TextViewUtil.underline(tvPhone);
        TextViewUtil.underline(tvInstagram);
        TextViewUtil.underline(tvFacebook);
        TextViewUtil.underline(tvGithub);
        TextViewUtil.underline(tvLinkedin);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Resources resources = getResources();
        presenter = new ContactPresenter(this, new Person(
                resources.getString(R.string.my_name),
                resources.getString(R.string.my_email),
                resources.getString(R.string.my_phone),
                resources.getString(R.string.my_instagram),
                resources.getString(R.string.my_facebook),
                resources.getString(R.string.my_github),
                resources.getString(R.string.my_linkedin)
        ));
        presenter.start();

        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEmailClicked();
            }
        });

        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPhoneClicked();
            }
        });

        tvInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onInstagramClicked();
            }
        });

        tvFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFacebookClicked();
            }
        });

        tvGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onGithubClicked();
            }
        });

        tvLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLinkedinClicked();
            }
        });
    }

    @Override
    public void showEmail(String email) {
        tvEmail.setText(email);
    }

    @Override
    public void showPhone(String phone) {
        tvPhone.setText(phone);
    }

    @Override
    public void showInstagram(String instagram) {
        tvInstagram.setText(instagram);
    }

    @Override
    public void showFacebook(String facebook) {
        tvFacebook.setText(facebook);
    }

    @Override
    public void showLinkedin(String linkedin) {
        tvLinkedin.setText(linkedin);
    }

    @Override
    public void showGithub(String github) {
        tvGithub.setText(github);
    }

    @Override
    public void openEmailApps(String email) {
        String url = "mailto:" + email;
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void openPhone(String phone) {
        String url = "tel:" + phone;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void openInstagram(String instagram) {
        String url = "https://instagram.com/" + instagram;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void openFacebook(String facebook) {
        String url = "https://facebook.com/" + facebook;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void openLinkedin(String linkedin) {
        String url = "https://linkedin.com/in/" + linkedin;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void openGithub(String github) {
        String url = "https://github.com/" + github;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
