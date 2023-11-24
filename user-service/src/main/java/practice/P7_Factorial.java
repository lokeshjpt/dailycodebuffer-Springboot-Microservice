package practice;

public class P7_Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static long factorial(int n) {
        if (n == 1) 
            return 1;
        else
            return n * factorial(n-1);
    }
    
}
