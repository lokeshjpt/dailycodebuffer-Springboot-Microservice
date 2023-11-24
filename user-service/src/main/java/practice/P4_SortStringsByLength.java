package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P4_SortStringsByLength {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("helloworld", "test", "start", "welcome");
        Collections.sort(stringList, Collections.reverseOrder()); // desc
        System.out.println(stringList);
        Collections.sort(stringList); // asc
        System.out.println(stringList);
        stringList = stringList.stream().sorted((e1, e2) -> e1.length() - e2.length()).collect(Collectors.toList()); // sort by lengths asc
        System.out.println(stringList);
        stringList = stringList.stream().sorted((e1, e2) -> e2.length() - e1.length()).collect(Collectors.toList()); // sort by lengths desc
        System.out.println(stringList);
        stringList = stringList.stream().sorted((e1, e2) -> Integer.compare(e1.length(), e2.length())).collect(Collectors.toList()); // sort by lengths asc
        System.out.println(stringList);
        stringList = stringList.stream().sorted((e1, e2) -> Integer.compare(e2.length(), e1.length())).collect(Collectors.toList()); // sort by lengths desc
        System.out.println(stringList);
        stringList = stringList.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()); // sort by lengths asc
        System.out.println(stringList);
        stringList = stringList.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList()); // sort by lengths desc
        System.out.println(stringList);
    }
    
}
