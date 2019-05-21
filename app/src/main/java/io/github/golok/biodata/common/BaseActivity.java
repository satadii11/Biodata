package io.github.golok.biodata.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected void show(Class destination) {
        Intent intent = new Intent(this, destination);
        startActivity(intent);
    }
}
