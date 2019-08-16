package io.github.golok.biodata.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseActivity;
import io.github.golok.biodata.login.LoginActivity;
import io.github.golok.biodata.repository.UserRepository;
import io.github.golok.biodata.services.room.AppDatabase;
import io.github.golok.biodata.utils.TextViewUtil;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    private EditText etName;
    private EditText etNim;
    private EditText etPassword;
    private TextView tvLogin;
    private Button btnRegister;

    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.et_register_name);
        etNim = findViewById(R.id.et_register_nim);
        etPassword = findViewById(R.id.et_register_password);
        tvLogin = findViewById(R.id.tv_register_login);
        btnRegister = findViewById(R.id.btn_register);

        AppDatabase database = AppDatabase.getInstance(getApplicationContext());
        UserRepository userRepository = UserRepository.getInstance(database.userDao());
        presenter = new RegisterPresenter(this, userRepository);

        TextViewUtil.colorSpannable(tvLogin, R.string.message_sudah_punya_akun, "di sini");

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.super.onBackPressed();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) register();
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLogin() {
        Intent intent = new Intent(this, LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private boolean validate() {
        boolean success = true;
        if (TextUtils.isEmpty(etName.getText())) {
            success = false;
            etName.setError("Pastikan tidak kosong!");
        }

        if (TextUtils.isEmpty(etNim.getText())) {
            success = false;
            etNim.setError("Pastikan tidak kosong!");
        }

        if (TextUtils.isEmpty(etPassword.getText())) {
            success = false;
            etPassword.setError("Pastikan tidak kosong!");
        }

        return success;
    }

    private void register() {
        String name = etName.getText().toString();
        String nim = etNim.getText().toString();
        String password = etPassword.getText().toString();
        presenter.register(name, nim, password);
    }
}
