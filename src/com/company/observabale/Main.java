package com.company.observabale;

public class Main {
    public static void main(String[] args) {

        ONewsAgency observable = new ONewsAgency();
        ONewsChannel observer = new ONewsChannel();

        observable.addObserver(observer);
        observable.setNews("newss");
        System.out.println((observer.getNews()));

    }
}