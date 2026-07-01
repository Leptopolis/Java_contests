import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine().trim());
        int[] prices = new int[n];
        
        String[] parts = reader.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(parts[i]);
        }
        if(n < 2){
            System.out.println(0);
            return;
        }

        long[] left = new long[n];
        long[] right = new long[n];

        int minPrice = prices[0];
        long maxProfit = 0;

        for(int i = 0;i < n;i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            left[i] = maxProfit;
        }

        int maxPrice = prices[n - 1];
        maxProfit = 0;

        for(int i = n - 1;i >= 0;i--){
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            right[i] = maxProfit;
        }

        long result = 0;
        for(int i = 0;i < n - 1;i++){
            result = Math.max(result, left[i] + right[i + 1]);
        }

        result = Math.max(result, left[n - 1]);

        System.out.println(result);

    }
}