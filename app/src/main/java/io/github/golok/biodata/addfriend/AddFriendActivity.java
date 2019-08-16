package io.github.golok.biodata.addfriend;

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
public class AddFriendActivity extends BaseActivity implements AddFriendContract.View {

    private EditText etName;
    private EditText etNim;
    private EditText etClass;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etInstagram;
    private Button btnSave;

    private AddFriendPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        etName = findViewById(R.id.et_add_name);
        etNim = findViewById(R.id.et_add_nim);
        etClass = findViewById(R.id.et_add_kelas);
        etEmail = findViewById(R.id.et_add_email);
        etPhone = findViewById(R.id.et_add_phone);
        etInstagram = findViewById(R.id.et_add_instagram);
        btnSave = findViewById(R.id.btn_add_save);

        AppDatabase database = AppDatabase.getInstance(getApplicationContext());
        FriendRepository friendRepository = FriendRepository.getInstance(database.personDao());
        presenter = new AddFriendPresenter(friendRepository, this);

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
                .putExtra(FriendDetailActivity.EXTRA_PERSON, person);
        startActivity(intent);
        finish();
    }
}
