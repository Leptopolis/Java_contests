import java.util.*;
import java.io.*;


public class D {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstline = br.readLine().split(" ");
        int n = Integer.parseInt(firstline[0]);
        int k = Integer.parseInt(firstline[1]);

        String[] numbers = br.readLine().split(" ");

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(String numStr: numbers){
            long num = Long.parseLong(numStr);
            long temp = num;
            int position = 0;
            while(temp > 0){
                long digit = temp % 10;
                long gain = (9 - digit) * (long)Math.pow(10, position);
                if(gain > 0){
                    pq.offer(gain);
                }
                temp /= 10;
                position++;
            }
        }

        long max = 0;
        int operations = Math.min(k, pq.size());

        for(int i = 0;i < operations;i++){
            max += pq.poll();
        }

        System.out.println(max);
    }
}