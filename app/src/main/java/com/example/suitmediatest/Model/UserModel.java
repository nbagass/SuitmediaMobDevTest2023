package com.example.suitmediatest.Model;

import android.net.Uri;

public class UserModel {

    private String firstName,lastName,email;
    private Uri img;

    public UserModel(String firstName, String lastName, String email, Uri img) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.img = img;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Uri getImg() {
        return img;
    }

    public void setImg(Uri img) {
        this.img = img;
    }
}
