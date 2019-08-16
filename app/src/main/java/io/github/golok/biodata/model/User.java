package io.github.golok.biodata.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
@Entity
public class User {
    @PrimaryKey
    @NonNull
    private String nim;
    private String nama;
    private String password;

    @Ignore
    public User() {
    }

    public User(@NonNull String nim, String nama, String password) {
        this.nim = nim;
        this.nama = nama;
        this.password = password;
    }

    @NonNull
    public String getNim() {
        return nim;
    }

    public void setNim(@NonNull String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
