package homework_17.Logger;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Logger {
    private String path;
    private FileWriter writer;
    private FileReader reader;
    private ExecutorService threads;
    private final Timer timer;
    private final Integer amountOfThreads;

    /**
     * Объект содержит логику для записи информации в текстовый файл логгера, который передается в метод beginLogging().
     */
    private Callable<Void> startThreads = new Callable<Void>() {
        @Override
        public Void call() {
            try {
                System.out.println("Поток " + Thread.currentThread().getName() + " запустился.");
                while (timer.isAlive()) {
                    writer.write("Имя потока: " + Thread.currentThread().getName() + ". Время: " + new Date() + "\n");
                    Thread.sleep(new Random().nextInt(5_000));
                }
                writer.close();
                System.out.println("Поток " + Thread.currentThread().getName() + " закончился.");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            return null;
        }
    };

    @SneakyThrows
    public Logger(File file, Integer amountOfThreads, Timer timer) {
        file.createNewFile();
        this.path = file.getPath();
        this.writer = new FileWriter(file, true);
        this.reader = new FileReader(file);
        this.threads = Executors.newFixedThreadPool(amountOfThreads);
        this.timer = timer;
        this.amountOfThreads = amountOfThreads;
    }

    /**
     * Метод запускает потоки, которые записывают информацию в текстовый файл логгера.
     */
    @SneakyThrows
    public void beginLogging() {
        System.out.println("Запуск логирования...");
        List<Callable<Void>> collectingThreads = IntStream.range(0, amountOfThreads)
                .boxed()
                .map(i -> startThreads)
                .toList();
        List<Future<Void>> futures = threads.invokeAll(collectingThreads);
        threads.shutdown();
    }

    /**
     * Метод для чтения текстового файла логгера.
     */
    public void readFile() {
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
