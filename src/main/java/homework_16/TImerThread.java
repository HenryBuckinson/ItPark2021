package homework_16;

/**
 * Поток-таймер
 */
public class TImerThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Таймер запустился.");
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
