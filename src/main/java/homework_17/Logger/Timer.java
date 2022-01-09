package homework_17.Logger;

public class Timer extends Thread {

    private final Integer milliseconds;

    public Timer(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        try {
            System.out.println("Таймер запустился.");
            Thread.sleep(this.milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
