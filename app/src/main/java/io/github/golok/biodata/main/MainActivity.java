package io.github.golok.biodata.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseActivity;
import io.github.golok.biodata.contact.ContactFragment;
import io.github.golok.biodata.friends.FriendsFragment;
import io.github.golok.biodata.profile.ProfileFragment;
import io.github.golok.biodata.utils.SharedPreferencesUtil;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class MainActivity extends BaseActivity {
    public static final String EXTRA_DATA = "extra::data";

    private BottomNavigationView bnvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnvMain = findViewById(R.id.bnv_main);

        boolean isFromDetail = getIntent().getBooleanExtra(EXTRA_DATA, false);
        Fragment fragment = isFromDetail ? new FriendsFragment() : new ProfileFragment();
        int menuSelected = isFromDetail ? R.id.menu_bottom_navigation_friends
                : R.id.menu_bottom_navigation_profile;
        replaceFragment(fragment);
        bnvMain.setSelectedItemId(menuSelected);
        bnvMain.setOnNavigationItemReselectedListener(null);
        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_bottom_navigation_friends:
                        replaceFragment(new FriendsFragment());
                        return true;
                    case R.id.menu_bottom_navigation_profile:
                        replaceFragment(new ProfileFragment());
                        return true;
                    case R.id.menu_bottom_navigation_contact:
                        replaceFragment(new ContactFragment());
                        return true;
                }

                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main, fragment)
                .commit();
    }
}
