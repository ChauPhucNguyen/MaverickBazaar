package com.example.communications_t3;

public class Contact {
    public String Name;
    public String phoneNumber;

    public Contact(){

    }
    public String getName() {
        return Name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Contact (String Name,String phoneNumber) {
        this.Name = Name;
        this.phoneNumber = phoneNumber;
    }
}
