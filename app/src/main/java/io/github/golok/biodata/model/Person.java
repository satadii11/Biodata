package io.github.golok.biodata.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
@Entity
public class Person implements Parcelable, Comparable<Person> {
    @PrimaryKey
    @NonNull
    private String nim;
    @Ignore
    private int foto;
    private String nama;
    private String kelas;
    private String deskripsi;
    private String email;
    private String birthDay;
    private String phone;
    private String instagram;
    private String facebook;
    private String github;
    private String linkedin;

    public Person(@NonNull String nim, String nama, String kelas, String deskripsi, String email,
                  String birthDay, String phone, String instagram, String facebook, String github,
                  String linkedin) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.deskripsi = deskripsi;
        this.email = email;
        this.birthDay = birthDay;
        this.phone = phone;
        this.instagram = instagram;
        this.facebook = facebook;
        this.github = github;
        this.linkedin = linkedin;
    }

    @Ignore
    public Person(int foto, String nama, String nim, String kelas, String deskripsi, String birthDay) {
        this.foto = foto;
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.deskripsi = deskripsi;
        this.birthDay = birthDay;
    }

    @Ignore
    public Person(String nama, String nim, String kelas, String email, String phone,
                  String instagram) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.email = email;
        this.phone = phone;
        this.instagram = instagram;
    }

    @Ignore
    public Person(String nama, String email, String phone, String instagram, String facebook, String github,
                  String linkedin) {
        this.nama = nama;
        this.email = email;
        this.phone = phone;
        this.instagram = instagram;
        this.facebook = facebook;
        this.github = github;
        this.linkedin = linkedin;
    }

    @Ignore
    protected Person(Parcel in) {
        foto = in.readInt();
        nama = in.readString();
        nim = in.readString();
        kelas = in.readString();
        deskripsi = in.readString();
        email = in.readString();
        birthDay = in.readString();
        phone = in.readString();
        instagram = in.readString();
        facebook = in.readString();
        github = in.readString();
        linkedin = in.readString();
    }

    @Override
    public int compareTo(Person other) {
        return getNim().compareTo(other.getNim());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(foto);
        dest.writeString(nama);
        dest.writeString(nim);
        dest.writeString(kelas);
        dest.writeString(deskripsi);
        dest.writeString(email);
        dest.writeString(birthDay);
        dest.writeString(phone);
        dest.writeString(instagram);
        dest.writeString(facebook);
        dest.writeString(github);
        dest.writeString(linkedin);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }

        Person another = (Person) obj;
        return another.getNim().equals(getNim());
    }

    public void setNim(@NonNull String nim) {
        this.nim = nim;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getKelas() {
        return kelas;
    }

    public int getFoto() {
        return foto;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }
}
