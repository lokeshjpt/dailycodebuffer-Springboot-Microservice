package practice;

import java.util.PriorityQueue;

public class MinHeapMaxHeap {


    public static void main(String[] args) {
    
        int[] nums = new int[]{4,6,5,2,7,9,1};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int num: nums) {
            minHeap.add(num);
            maxHeap.add(num);
        }
        System.out.println("min value: "+minHeap.peek());
        System.out.println("max value: "+maxHeap.peek());

    }

}
