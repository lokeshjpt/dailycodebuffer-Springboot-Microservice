package practice;

import java.util.stream.IntStream;

public class P6_PrimeNumbers {

    public static void main(String[] args) {   
        int n = 17;
        System.out.println(isPrime(n));
        IntStream.range(0, 100).forEach(x -> {
            if (isPrime(x)) System.out.printf("%d is prime \n", x);
        });     
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for(int i = 2; i * i <=n ; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
}
