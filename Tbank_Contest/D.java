import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        long x = Long.parseLong(firstLine[1]);
        
        long[] a = new long[n];
        String[] coins = reader.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(coins[i]);
        }
        
        System.out.println(minCoins(n, x, a));
        
        reader.close();
    }
    
    private static long minCoins(int n, long x, long[] a) {
        if (x == 0) return 0;
        
        long[] denom = a;
        
        java.util.function.Function<Long, Long> countCoins = (s) -> {
            long sum = s;
            long count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (sum >= denom[i]) {
                    count += sum / denom[i];
                    sum %= denom[i];
                }
            }
            return count;
        };
        
        long result = Long.MAX_VALUE;
        
        long maxY = x + denom[n - 1];
        
        for (long y = x; y <= maxY; y++) {
            long totalCoins = countCoins.apply(y) + countCoins.apply(y - x);
            result = Math.min(result, totalCoins);
        }
        
        return result;
    }
}