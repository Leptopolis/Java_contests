import java.util.Scanner;
import java.util.Arrays;

public class C {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++) a[i] = scanner.nextInt();
        int k = scanner.nextInt();
        int max = a[n - 1];
        int min = a[0];
        
        if(a[k - 1] - min <= t) System.out.println(max - 1);
        else{
            if(a[k - 1] - min < max - a[k - 1]) System.out.println(max - min + (a[k - 1] - min));
            else System.out.println(max - min + (max - a[k  - 1]));
        }

    }
}