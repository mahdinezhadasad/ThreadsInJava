package com.company.five;

import java.math.BigInteger;

public class bigInteger {

    public static void main(String[] args) {

    }


    private static class LongComputationTask implements Runnable{

        private BigInteger base;
        private BigInteger power;


        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {

            System.out.println(pow(base,power));

        }

        private BigInteger pow (BigInteger base, BigInteger power){

            BigInteger res = BigInteger.ONE;

            for(BigInteger i= BigInteger.ZERO; i.compareTo(power) !=0; i = i.add(BigInteger.ONE)){

                res = res.multiply(base);

            }

            return res;


        }
    }
}
