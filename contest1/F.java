import java.io.*;
import java.util.*;

public class F{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().trim().split("\\s+");
        
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(input[i]);
        }
        List<Integer> ev = new ArrayList<>();
        List<Integer> od = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(i % 2 == 0 && a[i] % 2 == 0) ev.add(i + 1);
            if(i % 2 != 0 && a[i] % 2 != 0) od.add(i+1);
        }
        if(ev.size() == 1 && od.size() == 1){
            if(ev.get(0) > od.get(0)) System.out.println(ev.get(0) + " " + od.get(0));
            else System.out.println(od.get(0) + " " + ev.get(0));
            return;
        }

        System.out.println("-1 -1");
    }
}