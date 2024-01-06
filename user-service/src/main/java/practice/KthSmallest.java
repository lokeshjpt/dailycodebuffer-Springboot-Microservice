package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallest {

    public static void main(String[] args) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a); // max heap
        int k = 4;
        int[] numbs = new int[]{ 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        // 2 3 4 5 6 10 10 33 48 53
        for (int num: numbs) {
            maxHeap.offer(num);

            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        System.out.println("Kth smallest: " + maxHeap.peek()); // kth smallest

        // -------------------------------------- //

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b); // min heap
        k = 2;
        for (int num: numbs) {
            minHeap.offer(num);

            if (minHeap.size() > k)
                minHeap.poll();
        }
        System.out.println("Kth largest" + minHeap.peek()); // kth largest


        int[] nums = new int[]{1,1,1,2,2,3};
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeapByCount = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b)); // max heap
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num: map.keySet()) {
            maxHeapByCount.add(num);
            if(maxHeapByCount.size() > k)
                maxHeapByCount.poll();
        }
        int[] result = new int[k];
        System.out.println("Top K freq elems");
        while (k>0) {
            int elem = maxHeapByCount.poll();
            result[--k] = elem;
            System.out.println(elem);
        }
        
    }
    
}
