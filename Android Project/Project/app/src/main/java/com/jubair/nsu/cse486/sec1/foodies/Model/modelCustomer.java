package com.jubair.nsu.cse486.sec1.foodies.Model;

public class modelCustomer {
    String Name;
    String Price;
    String ImageUri;

    public modelCustomer() {
    }

    public modelCustomer(String Name, String Price,String ImageUri) {
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

    public String getImageUri() {
        return ImageUri;
    }

    public void setImageUri(String imageUri) {
        ImageUri = imageUri;
    }
}
