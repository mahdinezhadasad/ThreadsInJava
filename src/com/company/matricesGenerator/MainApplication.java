package com.company.matricesGenerator;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainApplication {
    private static final int N =10;

    public static void main(String[] args) {


    }

    private static class MatricesReaderProducer extends Thread{
        private Scanner scanner;
        private ThreadSafeQueue queue;

        public MatricesReaderProducer(FileReader reader, ThreadSafeQueue queue) {
            this.scanner = new Scanner(reader);
            this.queue = queue;
        }


        private float [][] readMatrix(){
            float [][]  matrix = new float[N][N];
            for(int r=0; r < N; r++){
                if(!scanner.hasNext()){
                    return null;
                                    }

                String []  line = scanner.nextLine().split(",");
                for(int c=0; c<N;c++){

                    matrix[r][c] = Float.parseFloat(line[c]);
                }


            }
            scanner.nextLine();
            return matrix;


        }



    }
    private static class ThreadSafeQueue{
        private Queue<MatricesPair> queue = new LinkedList<>();
        private boolean isEmpty = true;
        private boolean isTerminate = false;
        public synchronized void add(MatricesPair matricesPair){
            queue.add(matricesPair);
            isEmpty =false;
            notify();

        }
        public synchronized MatricesPair remove(){
            while(isEmpty&& !isTerminate){

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(queue.size()==1){
                    isEmpty = true;
                }
                if(queue.size() ==0&& isTerminate){

                    return null;
                }

            }
            System.out.println("queue size " + queue.size());

            return queue.remove();
        }
        public synchronized  void terminate(){

            isTerminate=true;
            notifyAll();

        }
   }

    private static class MatricesPair{
        public float[][] matrix1;
        public float[][] matrix2;


    }
}
