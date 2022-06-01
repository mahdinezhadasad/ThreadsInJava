package com.company.second;

public class Main {

    public static void main(String[] args) {
        Thread thread = new NewThread();

        thread.start();
    }




    private static class NewThread extends Thread{


        public void run(){


            System.out.println("Hello from " + Thread.currentThread().getName());
        }


    }
}
