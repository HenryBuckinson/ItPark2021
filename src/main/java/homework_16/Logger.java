package homework_16;

import java.io.*;

/**
 * Класс для создания объекта логгера.
 */
public class Logger {
    private String path;
    private FileWriter writer;
    private FileReader reader;

    public FileWriter getWriter() {
        return writer;
    }

    public Logger(File file) throws IOException {
        file.createNewFile();
        this.path = file.getPath();
        this.writer = new FileWriter(file, true);
        this.reader = new FileReader(file);
    }

    /**
     * Метод отображает в консоль информацию из текстового файла, в результате работы программы.
     */
    public void readObject() {
        System.out.println("Содержимое файла логгера:");
        try (BufferedReader reader = new BufferedReader(this.reader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
