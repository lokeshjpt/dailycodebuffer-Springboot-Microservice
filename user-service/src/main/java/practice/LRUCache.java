package practice;

import java.util.LinkedList;

public class LRUCache {

    private static LinkedList<Integer> list = new LinkedList<>();
    private static int capacity = 3;
    public static void main(String[] args) {
        
        cachePut(5);
        cachePut(6);
        cachePut(7);
        System.out.println(list);
        cacheGet(5);
        cacheGet(6);
        System.out.println(list);
        cachePut(8);
        cachePut(9);

        System.out.println(list);
        
    }

    private static void cachePut(int e) {
        if (list.size()+1 > capacity) {
            list.pollFirst();
        }
        list.addLast(e);
    }

    private static int cacheGet(int e){
        int index = list.indexOf(e);
        if (index != -1 ) {
            int elem = list.get(index);
            list.remove(index);
            list.addLast(elem);
            return elem;
        }
        return -1;
    }
}
