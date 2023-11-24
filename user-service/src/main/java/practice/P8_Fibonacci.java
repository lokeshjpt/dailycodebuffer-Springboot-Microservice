package practice;

public class P8_Fibonacci {
    public static void main(String[] args) {
        fibonacci(10);
    }

    public static void fibonacci(int n){
        int a = 0, b = 1;
        int sum = 0;
        for(int i=0; i < n; i++) {
            System.out.print(a +" ");
            sum = a + b;
            a = b;
            b = sum;
        }
    }
    
}
