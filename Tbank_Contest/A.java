import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        
        System.out.println(canMakePalindrome(s) ? "Yes" : "No");
    }
    
    private static boolean canMakePalindrome(String s) {
        int n = s.length();
        int suffixA = 0;
        int i = n - 1;
        while (i >= 0 && s.charAt(i) == 'a') {
            suffixA++;
            i--;
        }

        if (suffixA == n) {
            return true;
        }

        int left = 0;
        int right = n - suffixA - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}