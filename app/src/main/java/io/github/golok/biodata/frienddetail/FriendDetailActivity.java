package io.github.golok.biodata.frienddetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseActivity;
import io.github.golok.biodata.editfriend.EditFriendActivity;
import io.github.golok.biodata.main.MainActivity;
import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.utils.TextViewUtil;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class FriendDetailActivity extends BaseActivity implements FriendDetailContract.View {
    public static final String EXTRA_PERSON = "extra::person";

    private ScrollView svDetail;
    private Toolbar tbDetail;
    private TextView tvName;
    private TextView tvNim;
    private TextView tvKelas;
    private TextView tvPhone;
    private TextView tvInstagram;
    private TextView tvEmail;

    private FriendDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_detail);

        svDetail = findViewById(R.id.sv_detail);
        tbDetail = findViewById(R.id.tb_friend);
        tvName = findViewById(R.id.tv_friend_name);
        tvNim = findViewById(R.id.tv_friend_nim);
        tvKelas = findViewById(R.id.tv_friend_kelas);
        tvPhone = findViewById(R.id.tv_friend_phone);
        tvInstagram = findViewById(R.id.tv_friend_instagram);
        tvEmail = findViewById(R.id.tv_friend_email);

        TextViewUtil.underline(tvPhone);
        TextViewUtil.underline(tvInstagram);
        TextViewUtil.underline(tvEmail);

        Person friend = getIntent().getParcelableExtra(EXTRA_PERSON);
        presenter = new FriendDetailPresenter(this, friend);
        presenter.start();

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

        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEmailClicked();
            }
        });

        tbDetail.inflateMenu(R.menu.menu_detail);
        tbDetail.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_detail_edit:
                        presenter.edit();
                        return true;
                    case R.id.menu_detail_delete:
                        presenter.onDeleteClicked();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public void showName(String name) {
        tvName.setText(name);
    }

    @Override
    public void showNim(String nim) {
        tvNim.setText(nim);
    }

    @Override
    public void showKelas(String kelas) {
        tvKelas.setText(kelas);
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
    public void showInstragram(String instagram) {
        tvInstagram.setText(instagram);
    }

    @Override
    public void openDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this data?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.delete();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .show();
    }

    @Override
    public void openInstagram(String instagram) {
        String url = "https://instagram.com/" + instagram;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void openPhoneApps(String phone) {
        String url = "tel:" + phone;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void openEmailApps(String email) {
        String url = "mailto:" + email;
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(svDetail, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showEditForm(Person person) {
        Intent intent = new Intent(this, EditFriendActivity.class)
                .putExtra(EditFriendActivity.EXTRA_PERSON, person);
        startActivity(intent);
        finish();
    }

    @Override
    public void showMainActivity() {
        Intent intent = new Intent(this, MainActivity.class)
                .putExtra(MainActivity.EXTRA_DATA, true);
        startActivity(intent);
        finish();
    }
}
