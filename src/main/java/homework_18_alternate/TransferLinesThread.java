package homework_18_alternate;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TransferLinesThread implements Runnable {
    @Override
    @SneakyThrows
    public void run() {
        System.out.println("Распаковка текста файла запущена...");
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\homework_18_alternate_text.txt"))) {
            String line;
            long count = 1;
            while ((line = reader.readLine()) != null) {
                String order = "Файл № " + count + ".txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\java\\homework_18_alternate\\wrappedFiles\\" + order))) {
                    writer.write(line);
                }
                count++;
            }
        }
        System.out.println("Распаковка текста из файла завершена.");
    }
}
