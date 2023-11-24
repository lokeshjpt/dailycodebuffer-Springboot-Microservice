package practice;

import java.util.List;
import java.util.stream.IntStream;

public class P2_MapReduce {
    public static void main(String[] args) {
        
        List<Integer> intList = List.of(1,2,3,4,50,60,30,49,56);
        int sum = IntStream.range(1, 100).sum();
        long longSum = IntStream.range(1, 100).mapToLong(i->i).sum();
        double avg = IntStream.range(1, 100).mapToDouble(i->i).average().getAsDouble();
        
        int numSum = intList.stream().mapToInt(i->i).sum();
        numSum = intList.stream().reduce(0, (a,b)-> a+b);
        numSum = intList.stream().reduce(Integer::sum).get();
        int max = intList.stream().mapToInt(i->i).max().getAsInt();
        max = intList.stream().reduce((a,b) -> a > b ? a: b).get();
        max = intList.stream().reduce(Integer::max).get();
        int min = intList.stream().mapToInt(i->i).min().getAsInt();
        min = intList.stream().reduce((a,b) -> a < b ? a: b).get();
        min = intList.stream().reduce(Integer::min).get();
        double numAvg = intList.stream().parallel().mapToDouble(i->i).average().getAsDouble();
        numAvg = intList.parallelStream().mapToDouble(i->i).average().getAsDouble();
        numAvg = intList.stream().mapToDouble(i->i).average().getAsDouble();
        numAvg = intList.stream().parallel().mapToDouble(i->i).average().getAsDouble();

        
    }
    
}
