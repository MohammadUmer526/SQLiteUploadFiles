package com.example.sqliteupload.Model;

public class Food {
    private int id;
    private byte[] image;
    public Food(byte[] image, int id) {

        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
