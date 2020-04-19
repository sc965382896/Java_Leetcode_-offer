import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 三线程交替打印ABC

public class printABC {
    private static Lock lock = new ReentrantLock();
    private static Condition canPrint = lock.newCondition();
    private static int count = 0;

    public static void main(String[] args) {
        Runnable pA = () -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (count % 3 != 0) {
                        canPrint.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread() + ": A");
                    canPrint.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Runnable pB = () -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (count % 3 != 1) {
                        canPrint.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread() + ": B");
                    canPrint.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Runnable pC = () -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (count % 3 != 2) {
                        canPrint.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread() + ": C");
                    canPrint.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        new Thread(pA).start();
        new Thread(pB).start();
        new Thread(pC).start();
    }
}
