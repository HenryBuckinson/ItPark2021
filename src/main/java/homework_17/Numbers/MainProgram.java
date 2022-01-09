package homework_17.Numbers;

import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;


public class MainProgram {
    @SneakyThrows
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 10)
                .boxed()
                .map(i -> new Random().nextInt(0, 100))
                .toList();

        System.out.println("Максимальное значение число в коллекции: " + getMax(numbers));
        System.out.println("Минимальное значение число в коллекции: " + getMin(numbers));
        System.out.println("Среднее значение в коллекции: " + getAverage(numbers));
    }

    /**
     * @param sequence - коллекция из последовательности чисел.
     * @return Метод создает один поток, который возвращает максимальное значение элемента коллекции.
     */
    @SneakyThrows
    public static Integer getMax(List<Integer> sequence) {
        Integer result;
        ExecutorService computingThread = Executors.newSingleThreadExecutor();
        Callable<Integer> calculation = () -> {
            Integer max = Collections.max(sequence);
            return max;
        };
        Future<Integer> submit = computingThread.submit(calculation);
        result = submit.get();
        computingThread.shutdown();
        return result;
    }

    /**
     * @param sequence - коллекция из последовательности чисел.
     * @return Метод создает один поток, который возвращает минимальное значение элемента коллекции.
     */
    @SneakyThrows
    public static Integer getMin(List<Integer> sequence) {
        Integer result;
        ExecutorService computingThread = Executors.newSingleThreadExecutor();
        Callable<Integer> calculation = () -> {
            Integer min = Collections.min(sequence);
            return min;
        };
        Future<Integer> submit = computingThread.submit(calculation);
        result = submit.get();
        computingThread.shutdown();
        return result;
    }

    /**
     * @param sequence - коллекция из последовательности чисел.
     * @return Метод создает один поток, который возвращает среднее значение элементов коллекции.
     */
    @SneakyThrows
    public static Double getAverage(List<Integer> sequence) {
        Integer result;
        ExecutorService computingThread = Executors.newSingleThreadExecutor();
        Callable<Integer> calculation = () -> {
            Integer sum = sequence.stream().reduce(0, Integer::sum);
            return sum;
        };
        Future<Integer> submit = computingThread.submit(calculation);
        result = submit.get();
        computingThread.shutdown();
        return ((double) result / (double) sequence.size());
    }
}
