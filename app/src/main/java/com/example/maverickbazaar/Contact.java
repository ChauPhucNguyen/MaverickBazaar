package com.example.maverickbazaar;

import android.util.Log;

public class Contact {
    public String name;
    public String phoneNumber;

    public Contact(){
        Log.e("Im empty","empty contact");
        setName(null);
        setPhoneNumber(null);
    }

    public Contact(String name, String phoneNumber){
        Log.e("Im not empty",name + " " + phoneNumber);
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }
    public void setName(String name){this.name=name;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}

}

