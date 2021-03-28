package com.company;

public class Main {

    public static void main(String[] args) {
    	A a = new A();
		Thread1 thread1 = new Thread1(a);
		Thread2 thread2 = new Thread2(a);

		thread1.start();
		thread2.start();

    }
}
