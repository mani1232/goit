package ua.mani123.Module12;

import ua.mani123.EnableLogger;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz extends EnableLogger {

    public ArrayList<Thread> threads = new ArrayList<>();
    private final AtomicInteger n;
    private final int defaultNum;
    private final BlockingQueue<String> queue;

    public FizzBuzz(int n) {
        this.n = new AtomicInteger(n);
        this.defaultNum = n;
        this.queue = new LinkedBlockingQueue<>();
    }

    public void fizz(AtomicInteger atomicInteger) {
        int i = atomicInteger.get();
        while (i > 0) {
            i = atomicInteger.get();
            if (i % 3 == 0 && i % 5 != 0) {
                queue.add("fizz");
                atomicInteger.decrementAndGet();
            }
        }
    }

    public void buzz(AtomicInteger atomicInteger) {
        int i = atomicInteger.get();
        while (i > 0) {
            i = atomicInteger.get();
            if (i % 3 != 0 && i % 5 == 0) {
                queue.add("buzz");
                atomicInteger.decrementAndGet();
            }
        }
    }

    public void fizzbuzz(AtomicInteger atomicInteger) {
        int i = atomicInteger.get();
        while (i > 0) {
            i = atomicInteger.get();
            if (i % 3 == 0 && i % 5 == 0) {
                queue.add("fizzbuzz");
                atomicInteger.decrementAndGet();
            }
        }
    }

    public void number(AtomicInteger atomicInteger) {
        int i = atomicInteger.get();
        while (i > 0) {
            i = atomicInteger.get();
            if (i % 3 != 0 && i % 5 != 0) {
                queue.add(Integer.toString(i));
                atomicInteger.decrementAndGet();
            }
        }

    }

    public void printResult() throws InterruptedException {
        threads.add(new Thread(() -> fizz(n)));
        threads.add(new Thread(() -> buzz(n)));
        threads.add(new Thread(() -> fizzbuzz(n)));
        threads.add(new Thread(() -> number(n)));

        threads.forEach(Thread::start);

        for (int i = 1; i <= defaultNum; i++) {
            logger.info(queue.take());
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
