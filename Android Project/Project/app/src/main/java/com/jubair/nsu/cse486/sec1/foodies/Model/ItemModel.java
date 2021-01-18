package com.jubair.nsu.cse486.sec1.foodies.Model;

public class ItemModel
    {
        String Name,Price,ImageUri;
        ItemModel()
        {

        }
    public ItemModel(String Name, String Price, String ImageUri) {
        this.Name = Name;
        this.Price = Price;
        this.ImageUri = ImageUri;
    }

        public String getName() {
        return Name;
    }

        public void setName(String Name) {
        this.Name = Name;
    }

        public String getPrice() {
        return Price;
    }

        public void setPrice(String Price) {
        this.Price = Price;
    }


        public String getPurl() {
        return ImageUri;
    }

        public void setPurl(String purl) {
        this.ImageUri = ImageUri;
    }

    }
