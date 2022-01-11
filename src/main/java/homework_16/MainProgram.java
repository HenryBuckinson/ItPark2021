package homework_16;

import java.io.File;
import java.io.IOException;

public class MainProgram {
    public static void main(String[] args) throws InterruptedException, IOException {
        File file = new File("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\java\\homework_16\\Logger.txt");
        Logger objLogger = new Logger(file);
        TImerThread timer = new TImerThread();

        WriterThread thd1 = new WriterThread(objLogger, timer);
        WriterThread thd2 = new WriterThread(objLogger, timer);
        WriterThread thd3 = new WriterThread(objLogger, timer);

        timer.start();
        thd1.start();
        thd2.start();
        thd3.start();
        timer.join();

        Thread.sleep(5_000);

        System.out.println();
        objLogger.readObject();
    }

}
