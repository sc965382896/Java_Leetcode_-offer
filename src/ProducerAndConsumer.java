import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 生产者消费者模型

public class ProducerAndConsumer {
    private final static Lock lock = new ReentrantLock();
    private final static Condition hasResource = lock.newCondition();
    private static int resource = 0;

    private static void produce() {
        lock.lock();
        try {
            while (resource >= 10) {
                hasResource.await();
            }
            resource++;
            hasResource.signalAll();
            System.out.println("resource: " + resource);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable p = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    produce();
                }
            }
        };
        Runnable c = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.lock();
                    try {
                        while (resource <= 0) {
                            hasResource.await();
                        }
                        resource--;
                        System.out.println(Thread.currentThread() + "resource: " + resource);
                        hasResource.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(p).start();
            new Thread(c).start();
        }
    }
}
