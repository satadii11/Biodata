package io.github.golok.biodata.friends;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.golok.biodata.R;
import io.github.golok.biodata.frienddetail.FriendDetailActivity;
import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {
    private Context context;

    private List<Person> friends;

    FriendsAdapter(Context context, List<Person> friends) {
        this.context = context;
        this.friends = friends;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_friends, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(friends.get(position));
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvClass;
        private TextView tvName;
        private TextView tvNim;
        private TextView tvEmail;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvClass = itemView.findViewById(R.id.tv_friend_class);
            tvName = itemView.findViewById(R.id.tv_friend_name);
            tvNim = itemView.findViewById(R.id.tv_friend_nim);
            tvEmail = itemView.findViewById(R.id.tv_friend_email);
        }

        private void bind(final Person friend) {
            tvClass.setText(friend.getKelas());
            tvName.setText(friend.getNama());
            tvNim.setText(friend.getNim());
            tvEmail.setText(friend.getEmail());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FriendDetailActivity.class)
                            .putExtra(FriendDetailActivity.EXTRA_PERSON, friend);
                    context.startActivity(intent);
                }
            });
        }
    }
}
