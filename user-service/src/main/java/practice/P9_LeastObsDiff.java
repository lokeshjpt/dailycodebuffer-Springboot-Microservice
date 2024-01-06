package practice;

import java.util.List;

public class P9_LeastObsDiff {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,3,4,5);
        int s1=0,s2=0;
        for(int i=0; i<list.size(); i++) {
            int d1 = s1+list.get(i) - s2+list.get(i);
            int d2 = s2+list.get(i) - s1+list.get(i);
            if (d1 < d2) {
                s1 += list.get(i);
            } else {
                s2 += list.get(i);
            }
        }
        System.out.println(s1-s2);
    }

    
}
