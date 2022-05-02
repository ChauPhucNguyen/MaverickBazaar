package com.example.maverickbazaar;


public class storeInfo {
    public String item_name;
    public String item_details;
    public String item_price;

    public storeInfo(){

    }

    public storeInfo(String item_name, String item_details, String item_price) {
        this.item_name = item_name;
        this.item_details = item_details;
        this.item_price = item_price;
    }
}