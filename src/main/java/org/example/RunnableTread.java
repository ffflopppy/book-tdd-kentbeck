package org.example;

public class RunnableTread {
    public void RunnableTread() {
        Thread t1 = new Thread(()-> {});
        t1.start();
        System.out.println("RunnableTread.t1 :::: "+ t1.getState());

        Runnable runnable1 = ()-> {};
        Thread t2 = new Thread(runnable1);
        t2.start();
        System.out.println("RunnableTread.t2 :::: "+ t2.getState());

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
        t3.start();
        System.out.println("RunnableTread.t3 :::: "+ t3.getState());

        Thread t4 = new Thread(new Thread());
        t4.start();
        System.out.println("RunnableTread.t4 :::: "+ t4.getState());
    }

}

