package com.company;

public class Thread1 extends Thread {
    A var;
    public Thread1(A var){
        this.var = var;
    }


    @Override
    public void run(){
        //for(int i = 0; i < 51; i++) {
            var.doSomething(0);
            //System.out.println("he ");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
       // }
    }


}
