package practice;

import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        List<String> x = null;
        for (String s: x) {
            System.out.println(s);
        }
        System.out.println("End of main");
    }

}
