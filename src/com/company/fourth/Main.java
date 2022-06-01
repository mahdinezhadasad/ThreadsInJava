package com.company.fourth;

public class Main {

    public static void main(String[] args) {

        Thread thread = new Thread(new BlockingTask());

        thread.start();


    }

    private static class BlockingTask implements Runnable{


        @Override
        public void run() {
            try {
                Thread.sleep(500000000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }
}
