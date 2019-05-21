package io.github.golok.biodata.repository;

import java.util.ArrayList;
import java.util.Collections;

import io.github.golok.biodata.model.Person;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class FriendRepository {
    private static FriendRepository instance;

    public static FriendRepository getInstance() {
        if (instance == null) {
            instance = new FriendRepository();
        }

        return instance;
    }

    private ArrayList<Person> friends = new ArrayList<Person>() {{
        add(new Person("Andri R.", "10116120", "IF-5", "bartoandri@gmail.com", "082122982122", "andri.rh"));
        add(new Person("Suyatna", "10116320", "IF-10", "suyatnah.fh@gmail.com", "085621763121", "zuya"));
        add(new Person("Lukmannudin", "10116212", "IF-8", "laode.lukmannudin@gmail.com", "081212567654", "lukmannudin"));
        add(new Person("Diki Supriadi", "10116213", "IF-8", "diki.s@gmail.com", "085652781234", "suarahati69"));
        add(new Person("Anisa Dewi", "10116183", "IF-6", "anisadewi@gmail.com", "089672126547", "andwuk"));
    }};

    private FriendRepository() {
        Collections.sort(friends);
    }

    public void addFriend(Person friend) {
        friends.add(friend);
        Collections.sort(friends);
    }

    public void removeFriend(Person friend) {
        friends.remove(friend);
        Collections.sort(friends);
    }

    public void updateFriend(Person oldFriend, Person newFriend) {
        friends.remove(oldFriend);
        friends.add(newFriend);
        Collections.sort(friends);
    }

    public ArrayList<Person> getFriends() {
        return friends;
    }
}
