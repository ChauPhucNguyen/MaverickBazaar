package com.example.maverickbazaar;

public class exchangeInfo {
    public String header;
    public String body;


    public exchangeInfo() {
    }

    public exchangeInfo (String header, String body) {
        this.header = header;
        this.body = body;
    }

    public String getHeader(){
        return header;
    }
    public void setHeader(String header){
        this.header=header;
    }

    public String getBody(){
        return body;
    }
    public void setBody(String body){
        this.body=body;
    }
}
