package com.lxy.threadlocal;

/**
 * ThreadLocal的实现
 */
public class SequenceNumber {
    private ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        Thread t1 = new TestClient(sn);
        Thread t2 = new TestClient(sn);
        Thread t3 = new TestClient(sn);

        t1.start();
        t2.start();
        t3.start();
    }

    public static class TestClient extends Thread {
        private SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread{" + Thread.currentThread().getName() + "} sn{" + sn.getNextNum() + "}");
            }
        }
    }
}
