package com.jubair.nsu.cse486.sec1.foodies.Model;

public class model {
    String Name;
    String Price;
    static String ImageUri;

    public model() {
    }

    public model(String Name, String Price,String ImageUri) {
        this.Name = Name;
        this.Price = Price;
        this.ImageUri = ImageUri;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public static String getImageUri() {
        return ImageUri;
    }

    public void setImageUri(String imageUri) {
        ImageUri = imageUri;
    }
}