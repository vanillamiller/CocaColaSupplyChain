package domain;


public class WriteLock {

    private int access = 0;
    private int requests = 0;
    private Thread writethread = null;

    synchronized void lock() throws InterruptedException {

        requests = requests + 1;

        Thread thisthread = Thread.currentThread();

        while (writethread != null) {
            wait();
        }
        iswritingthread(thisthread);

        requests = requests - 1;
        access = access + 1;

        writethread = thisthread;
    }

    synchronized void unlock() {

        if (!iswritingthread(Thread.currentThread())) {

            throw new IllegalMonitorStateException("No write lock on thread");

        }

        access = access - 1;

        if (access == 0 ) {
            writethread = null;
        }

        notifyAll();
    }


    private boolean iswritingthread(Thread thisthread) {
        return writethread == thisthread;
    }



}
