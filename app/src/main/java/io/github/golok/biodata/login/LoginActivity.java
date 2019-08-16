package io.github.golok.biodata.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseActivity;
import io.github.golok.biodata.main.MainActivity;
import io.github.golok.biodata.register.RegisterActivity;
import io.github.golok.biodata.repository.UserRepository;
import io.github.golok.biodata.services.room.AppDatabase;
import io.github.golok.biodata.utils.SharedPreferencesUtil;
import io.github.golok.biodata.utils.TextViewUtil;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {

    private EditText etNim;
    private EditText etPassword;
    private TextView tvRegister;
    private Button btnLogin;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (SharedPreferencesUtil.hasLogin(this)) {
            show(MainActivity.class);
            finish();
            return;
        }

        setContentView(R.layout.activity_login);

        etNim = findViewById(R.id.et_login_nim);
        etPassword = findViewById(R.id.et_login_password);
        tvRegister = findViewById(R.id.tv_login_register);
        btnLogin = findViewById(R.id.btn_login);

        AppDatabase database = AppDatabase.getInstance(getApplicationContext());
        UserRepository userRepository = UserRepository.getInstance(database.userDao());
        presenter = new LoginPresenter(userRepository, this);

        TextViewUtil.colorSpannable(tvRegister, R.string.message_belum_punya_akun, "di sini");

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(RegisterActivity.class);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) login();
            }
        });
    }

    @Override
    public void showMain(String name) {
        show(MainActivity.class);
        finish();
        SharedPreferencesUtil.setLogin(this, true);
        SharedPreferencesUtil.setName(this, name);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private boolean validate() {
        boolean success = true;
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

    private void login() {
        String nim = etNim.getText().toString();
        String password = etPassword.getText().toString();

        presenter.login(nim, password);
    }
}
