package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DispStringsByLength {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("helloworld", "test", "start", "welcome");
        System.out.println(stringList.stream().collect(Collectors.toMap(String::length, Function.identity())));
        System.out.println(stringList.stream().sorted((a,b) -> a.length() - b.length()).collect(Collectors.toList()));
        System.out.println(stringList.stream().sorted((a,b) -> b.length() - a.length()).collect(Collectors.toList()));
        stringList.sort(Comparator.comparingInt(String::length));
        System.out.println(stringList);
        stringList.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(stringList);
        String s = "helloworld";
        System.out.println(Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        /*
        {4=test, 5=start, 7=welcome, 10=helloworld}
        [test, start, welcome, helloworld]
        [helloworld, welcome, start, test]
        [test, start, welcome, helloworld]
        [helloworld, welcome, start, test]
        {r=1, d=1, e=1, w=1, h=1, l=3, o=2}
        */ 
    }
}
