package homework_18_experimental;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainProgram {
    public static void main(String[] args) {
        System.out.println();
        wrappingLines();


    }

    @SneakyThrows
    public static void wrappingLines() {
        System.out.println("Распаковка текста файла запущена...");
        try (BufferedReader reader = new BufferedReader(new FileReader("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\java\\homework_18_experimental\\RandomText.txt"))) {
            String line;
            long count = 1;
            while ((line = reader.readLine()) != null) {
                ExecutorService executorThread = Executors.newSingleThreadExecutor();
                String order = "Файл № " + count + ".txt";
                File file = new File("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\java\\homework_18_experimental\\wrappedFiles\\" + order);
                final String result = line;
                Runnable writing = new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        FileWriter write = new FileWriter(file);
                        write.write(result);
                        write.close();
                    }
                };
                executorThread.submit(writing);
                executorThread.shutdown();
                count++;
            }
        }
        System.out.println("Распаковка текста из файла завершена.");
    }
}
