package homework_17.Logger;

import lombok.SneakyThrows;

import java.io.File;

public class MainProgram {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println();

        File file = new File("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\java\\homework_17\\Logger\\Logger.txt");
        Timer timer = new Timer(30_000);
        Logger logger = new Logger(file, 3, timer);

        timer.start();
        while (timer.isAlive()) {
            logger.beginLogging();
            timer.join();
        }
        Thread.sleep(5_000);
        System.out.println();
        logger.readFile();
    }
}
