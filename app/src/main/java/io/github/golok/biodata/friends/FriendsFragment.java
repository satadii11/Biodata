package io.github.golok.biodata.friends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.golok.biodata.R;
import io.github.golok.biodata.addfriend.AddFriendActivity;
import io.github.golok.biodata.common.BaseFragment;
import io.github.golok.biodata.model.Person;
import io.github.golok.biodata.repository.FriendRepository;
import io.github.golok.biodata.services.room.AppDatabase;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class FriendsFragment extends BaseFragment implements FriendsContract.View {

    private FriendsPresenter presenter;
    private FriendsAdapter friendsAdapter;

    private RecyclerView rvFriends;
    private Toolbar tbFriends;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        rvFriends = view.findViewById(R.id.rv_friends);
        tbFriends = view.findViewById(R.id.tb_friends);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppDatabase database = AppDatabase.getInstance(getActivity().getApplicationContext());
        FriendRepository friendRepository = FriendRepository.getInstance(database.personDao());
        presenter = new FriendsPresenter(friendRepository, this);
        presenter.start();

        tbFriends.inflateMenu(R.menu.menu_friends);
        tbFriends.inflateMenu(R.menu.menu_main);
        tbFriends.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_add_friend:
                        presenter.addFriend();
                        return true;
                    case R.id.menu_logout:
                        logout();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setFriends(List<Person> friends) {
        friendsAdapter = new FriendsAdapter(getContext(), friends);
        rvFriends.setAdapter(friendsAdapter);
    }

    @Override
    public void showAddFriend() {
        Context context = getContext();
        if (context != null) {
            Intent intent = new Intent(context, AddFriendActivity.class);
            context.startActivity(intent);
        }
    }
}
