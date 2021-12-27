package homework_15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainProgram {
    public static void main(String[] args) {
        System.out.println();

//        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at \n" +
//                "faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit\n" +
//                "blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget\n" +
//                "vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer \n" +
//                "vel odio nec mi tempor dignissim.";

        String text = "Семь раз замерь, 1 раз отрежь!";

        //String text = "two one asd three rty two fgh three two one one one";

        List<String> result = transformText2(text);
        System.out.println(result);

        System.out.println();

        List<String> result2 = transformText(text);
        System.out.println(result2);
    }

    public static List<String> transformText(String text) {
        String[] resultOfSplit = text.split("\\s*(\\s|!|,|\\?|,|\\.|\\-)\\s*"); //Тире под вопросом?
        List<String> replayStrings = Arrays.stream(resultOfSplit).toList().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey()).toList();

        List<String> uniqStrings = Arrays.stream(resultOfSplit)
                .toList()
                .stream()
                .filter(str -> Collections.frequency(Arrays.stream(resultOfSplit).toList(), str) == 1)
                .toList();

        List<String> resultList = Stream.concat(replayStrings.stream(), uniqStrings.stream()).collect(Collectors.toList());
        return resultList;
    }

    public static List<String> transformText2(String text) {
        String[] resultOfSplit = text.split("\\s*(\\s|!|,|\\?|,|\\.|\\-)\\s*"); //Тире под вопросом?
        List<String> replayStrings = Arrays.stream(resultOfSplit)
                .toList()
                .stream().filter(str -> Collections.frequency(Arrays.stream(resultOfSplit).toList(), str) > 1)
                //.sorted()
                .distinct()
                .toList();

        List<String> uniqStrings = Arrays.stream(resultOfSplit)
                .toList()
                .stream()
                .filter(str -> Collections.frequency(Arrays.stream(resultOfSplit).toList(), str) == 1)
                .toList();

        List<String> resultList = Stream.concat(replayStrings.stream(), uniqStrings.stream()).collect(Collectors.toList());
        return resultList;
    }
}
