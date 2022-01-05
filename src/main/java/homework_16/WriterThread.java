package homework_16;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Поток записывает в текстовый файл информацию о его имени, и дате его записи.
 */
public class WriterThread extends Thread {
    private Logger logger;
    private Lock lck = new ReentrantLock();
    private Thread timer;

    public WriterThread(Logger logger, Thread timer) {
        this.logger = logger;
        this.timer = timer;
    }

    @Override
    public void run() {
        try {
            lck.tryLock();
            System.out.println("Поток " + Thread.currentThread().getName() + " запустился.");
            FileWriter writer = logger.getWriter();
            while (timer.isAlive()) {
                writer.write("Имя потока: " + Thread.currentThread().getName() + ". Время: " + new Date() + "\n");
                Thread.sleep(new Random().nextInt(5_000));
            }
            writer.close();
            System.out.println("Поток " + Thread.currentThread().getName() + " закончился.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            lck.unlock();
        }
    }
}
