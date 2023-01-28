package com.example.groupproject;

import androidx.annotation.NonNull;

public class Person {
    int Image;
    String Name;
    String stNo;
    String myClass;

    public Person(int image, String name, String stNo, String myClass) {
        Image = image;
        Name = name;
        this.stNo = stNo;
        this.myClass = myClass;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStNo() {
        return stNo;
    }

    public void setStNo(String stNo) {
        this.stNo = stNo;
    }

    public String getMyClass() {
        return myClass;
    }

    public void setMyClass(String myClass) {
        this.myClass = myClass;
    }
}
