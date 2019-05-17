package io.github.golok.biodata.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public static final String EXTRA_BUNDLE_DATA = "extra::bundle";

    protected void show(Class destination) {
        Intent intent = new Intent(this, destination);
        startActivity(intent);
    }

    protected void show(Class destination, Bundle extra) {
        Intent intent = new Intent(this, destination)
                .putExtra(extra.getString(EXTRA_BUNDLE_DATA), extra);
        startActivity(intent);
    }
}
