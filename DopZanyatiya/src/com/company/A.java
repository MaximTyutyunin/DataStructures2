package com.company;

public class A {
    int count = 0;
    boolean[] flag = new boolean[2];//which thread is ready to run
    int turn;//which thread is going to run

    public void doSomething(int j) {
        int i;//flag
        if( j == 0) {
            i = 1;
        }else{
            i = 0;
        }

        do{
            flag[i] = true;
            turn = j;
            while(flag[j] && turn == j){
                //critical section
                if(j == 0) {
                    count++;
                    System.out.println(count + "  thread1 run");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    count -=1;
                    System.out.println(count + " thread2 run");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }while(true);

    }
}
