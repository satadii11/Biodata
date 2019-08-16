package io.github.golok.biodata.editfriend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseActivity;
import io.github.golok.biodata.frienddetail.FriendDetailActivity;
import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.repository.FriendRepository;
import io.github.golok.biodata.services.room.AppDatabase;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class EditFriendActivity extends BaseActivity implements EditFriendContract.View {
    public static final String EXTRA_PERSON = "extra::person";

    private EditText etName;
    private EditText etNim;
    private EditText etClass;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etInstagram;
    private Button btnSave;

    private EditFriendContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_friend);

        etName = findViewById(R.id.et_edit_name);
        etNim = findViewById(R.id.et_edit_nim);
        etClass = findViewById(R.id.et_edit_kelas);
        etEmail = findViewById(R.id.et_edit_email);
        etPhone = findViewById(R.id.et_edit_phone);
        etInstagram = findViewById(R.id.et_edit_instagram);
        btnSave = findViewById(R.id.btn_edit_save);

        Person friend = getIntent().getParcelableExtra(EXTRA_PERSON);
        AppDatabase database = AppDatabase.getInstance(getApplicationContext());
        FriendRepository friendRepository = FriendRepository.getInstance(database.personDao());
        presenter = new EditFriendPresenter(friendRepository, friend, this);
        presenter.start();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.save(new Person(
                        etName.getText().toString(),
                        etNim.getText().toString(),
                        etClass.getText().toString(),
                        etEmail.getText().toString(),
                        etPhone.getText().toString(),
                        etInstagram.getText().toString()
                ));
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDetail(Person person) {
        Intent intent = new Intent(this, FriendDetailActivity.class)
                .putExtra(FriendDetailActivity.EXTRA_PERSON, person)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public void showName(String name) {
        etName.setText(name);
    }

    @Override
    public void showNim(String nim) {
        etNim.setText(nim);
    }

    @Override
    public void showClass(String kelas) {
        etClass.setText(kelas);
    }

    @Override
    public void showEmail(String email) {
        etEmail.setText(email);
    }

    @Override
    public void showPhone(String phone) {
        etPhone.setText(phone);
    }

    @Override
    public void showInstagram(String instagram) {
        etInstagram.setText(instagram);
    }
}
