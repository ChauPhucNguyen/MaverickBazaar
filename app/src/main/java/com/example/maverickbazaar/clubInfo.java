package com.example.maverickbazaar;


public class clubInfo  {
    public String club_name, club_details;

    public clubInfo() {

    }

    public clubInfo(String club_name,String club_details) {
        this.club_name = club_name;
        this.club_details = club_details;
    }

    public String getClub_name() {
        return club_name;
    }

    public String getClub_details() {
        return club_details;
    }

}