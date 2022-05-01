package com.example.maverickbazaar;

public class orderInfo {
    public String date;
    public String user;


    public orderInfo() {
    }

    public orderInfo (String date, String user) {
        this.date = date;
        this.user = user;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }

    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user=user;
    }
}