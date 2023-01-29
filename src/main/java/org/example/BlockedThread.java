package org.example;

public class BlockedThread {

    public void BlockedThread() {
        Thread t1 = new Thread(new SyncBlockCode());
        Thread t2 = new Thread(new SyncBlockCode());

        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Blocked thread t1 :: "+t1.getState() +" >> "+ t1.getState());
        System.out.println("Blocked thread t2 :: "+t1.getState() +" >> "+ t2.getState());

        System.exit(0);
    }


    private static class SyncBlockCode implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread "+ Thread.currentThread().getName() + " is in run() method");
            syncMethod();
        }

        private void syncMethod() {
            System.out.println("Thread " +Thread.currentThread().getName() + "is in syncMethod() method");
            while (1==1){
                // t1이 영원히 점유 하기 때문에 t2의 접근은 차단됨
            }
        }
    }
}