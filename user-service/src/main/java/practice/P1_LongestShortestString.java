package practice;

import java.util.List;

public class P1_LongestShortestString {

    public static void main(String[] args) {
       // longest string
        longestString();
       
       // shortest string
        shortestString();
       
    }

    private static void longestString() {
        // longest string
        List<String> wordList = List.of("test", "test1", "helloworld");
        String longestString = wordList.stream().reduce((word1, word2) -> word1.length() > word2.length()? word1: word2).get();
        System.out.println(longestString);
    }
    
    private static void shortestString() {
        // longest string
        List<String> wordList = List.of("test", "test1", "helloworld");
        String longestString = wordList.stream().reduce((word1, word2) -> word1.length() < word2.length()? word1: word2).get();
        System.out.println(longestString);
    }
}
