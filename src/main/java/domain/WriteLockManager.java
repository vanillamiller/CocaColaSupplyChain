package domain;

import java.util.HashMap;
import java.util.Map;

public class WriteLockManager {

    private final Map<Object, WriteLock> locks;

    private static WriteLockManager wlmanager;

    private WriteLockManager() {
        locks = new HashMap<>();
    }

    public static WriteLockManager getInstance() {
        if (WriteLockManager.wlmanager == null) {
            WriteLockManager.wlmanager = new WriteLockManager();
        }
        return WriteLockManager.wlmanager;
    }

    private WriteLock getWriteLock(Object tolock) {

        WriteLock lock = locks.get(tolock);

        if (lock == null) {
//            Thread thisthread = Thread.currentThread();
            WriteLock thislock = new WriteLock();
            locks.putIfAbsent(tolock, thislock);
            lock = locks.get(tolock);
        }

        return lock;
    }

    public synchronized void acquireWriteLock(Object toLock)
            throws InterruptedException {
        getWriteLock(toLock).lock();
    }

    public synchronized void releaseWriteLock(Object toLock) {

        getWriteLock(toLock).unlock();

    }

}
