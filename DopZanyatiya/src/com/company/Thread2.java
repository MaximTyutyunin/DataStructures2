package com.company;

public class Thread2 extends Thread {
    A var;
    public Thread2(A var){
        this.var = var;
    }
    @Override
    public void run(){
        //for(int i = 0; i < 51; i++) {
            var.doSomething(1);
            //System.out.println("haaaa ");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
       // }
    }


}
