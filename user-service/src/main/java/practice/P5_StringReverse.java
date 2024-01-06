package practice;

public class P5_StringReverse {

    public static void main(String[] args) {
        String test = "helloworld";
        char[] chars = test.toCharArray();
        int i = 0;
        int j = test.length() - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        System.out.println(String.valueOf(chars));
        System.out.println(palindrome("civic"));
    }

    static boolean palindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if(chars[i] != chars[j]) return false;
            i++;j--;
        }
        return true;
    }
    
}
