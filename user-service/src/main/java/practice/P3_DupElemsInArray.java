package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

public class P3_DupElemsInArray {
    public static void main(String[] args) {
        int[] intArr = new int[] {1,2,3,4,3,2,6,7};
        HashMap<Integer, Integer> dupElemsMap = new HashMap<>();
        Arrays.stream(intArr).forEach(e -> {
            Integer dupCount = dupElemsMap.get(e);
            if (dupCount == null)
                 dupElemsMap.put(e, 1);
            else
                dupElemsMap.put(e, ++dupCount);
        });
        
        boolean containsDups = dupElemsMap.keySet().parallelStream().filter(e -> dupElemsMap.get(e) > 1).findAny().isPresent();
        System.out.printf("contains dup: %b \n", containsDups);
        System.out.println("Duplicate elems:");
        dupElemsMap.keySet().parallelStream().filter(e -> dupElemsMap.get(e) > 1).forEach(System.out::println);

        // set approach

        HashSet<Integer> dupSet = new HashSet<>();
        for (Integer elem : intArr) {
            if (dupSet.add(elem) == false) {
                System.out.println("contains duplicates");
                break;
            }
        }
    }
    
}
