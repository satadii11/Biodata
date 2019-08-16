package io.github.golok.biodata.profile;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseFragment;
import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class ProfileFragment extends BaseFragment implements ProfileContract.View {

    private ProfileContract.Presenter presenter;

    private CircleImageView civPhoto;
    private TextView tvName;
    private TextView tvNim;
    private TextView tvDesc;
    private TextView tvKelas;
    private TextView tvBirthday;
    private Toolbar tbProfile;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        civPhoto = view.findViewById(R.id.civ_profile_photo);
        tvName = view.findViewById(R.id.tv_profile_name);
        tvNim = view.findViewById(R.id.tv_profile_nim);
        tvDesc = view.findViewById(R.id.tv_profile_description);
        tvKelas = view.findViewById(R.id.tv_profile_class);
        tvBirthday = view.findViewById(R.id.tv_profile_birthday);
        tbProfile = view.findViewById(R.id.tb_profile);

        tbProfile.inflateMenu(R.menu.menu_main);
        tbProfile.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.menu_logout) {
                    logout();
                    return true;
                }

                return false;
            }
        });

        Resources resources = getResources();
        presenter = new ProfilePresenter(new Person(
                R.drawable.me,
                resources.getString(R.string.my_name),
                resources.getString(R.string.my_nim),
                resources.getString(R.string.my_class),
                resources.getString(R.string.my_description),
                resources.getString(R.string.my_birthday)
        ), this);
        presenter.start();

        return view;
    }

    @Override
    public void showPhoto(int photoId) {
        civPhoto.setImageResource(photoId);
    }

    @Override
    public void showName(String name) {
        tvName.setText(name);
    }

    @Override
    public void showDescription(String desc) {
        tvDesc.setText(desc);
    }

    @Override
    public void showNim(String nim) {
        tvNim.setText(nim);
    }

    @Override
    public void showBirthday(String birthday) {
        tvBirthday.setText(birthday);
    }

    @Override
    public void showClass(String kelas) {
        tvKelas.setText(kelas);
    }
}
