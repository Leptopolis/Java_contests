import java.io.*;
import java.util.*;

public class E {
    private static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] parts = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        long m = Long.parseLong(parts[1]);
        
        System.out.println(countWays(n, m));
        
        reader.close();
    }
    
    private static long countWays(int n, long m) {
        if (n == 0) return 0;
        
        long m_mod = m % MOD;
        long m_minus_1 = (m - 1 + MOD) % MOD;
        long m_minus_2 = (m - 2 + MOD) % MOD;
        
        long first = (m_mod * m_minus_1) % MOD;
        
        if (n == 1) {
            return first;
        }
        
        long T = (m_minus_1 + (m_minus_2 * m_minus_2) % MOD) % MOD;
        
        long power = modPow(T, n - 1);
        
        return (first * power) % MOD;
    }
    
    private static long modPow(long base, long exp) {
        long result = 1;
        long b = base % MOD;
        long e = exp;
        
        while (e > 0) {
            if ((e & 1) == 1) {
                result = (result * b) % MOD;
            }
            b = (b * b) % MOD;
            e >>= 1;
        }
        
        return result;
    }
}