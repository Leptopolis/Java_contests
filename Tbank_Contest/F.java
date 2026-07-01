import java.io.*;
import java.util.*;

public class F{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = reader.readLine().trim().split(" ");
        int a = Integer.parseInt(firstLine[0]);
        int b = Integer.parseInt(firstLine[1]);
        int n = Integer.parseInt(firstLine[2]);
        
        long[][] skills = new long[n][2];
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().trim().split(" ");
            skills[i][0] = Long.parseLong(parts[0]);
            skills[i][1] = Long.parseLong(parts[1]);
        }
        
        System.out.println(maxTotalSkill(a, b, n, skills));
        
        reader.close();
    }
    
    private static long maxTotalSkill(int a, int b, int n, long[][] skills) {
        Arrays.sort(skills, (s1, s2) -> Long.compare(s2[0] - s2[1], s1[0] - s1[1]));
        
        long[] bestX = new long[n + 1];
        PriorityQueue<Long> minHeapX = new PriorityQueue<>();
        long sumX = 0;
        
        for (int i = 0; i < n; i++) {
            minHeapX.offer(skills[i][0]);
            sumX += skills[i][0];
            if (minHeapX.size() > a) {
                sumX -= minHeapX.poll();
            }
            if (minHeapX.size() == a) {
                bestX[i + 1] = sumX;
            } else {
                bestX[i + 1] = Long.MIN_VALUE;
            }
        }
        
        long[] bestY = new long[n + 1];
        PriorityQueue<Long> minHeapY = new PriorityQueue<>();
        long sumY = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            minHeapY.offer(skills[i][1]);
            sumY += skills[i][1];
            if (minHeapY.size() > b) {
                sumY -= minHeapY.poll();
            }
            if (minHeapY.size() == b) {
                bestY[i] = sumY;
            } else {
                bestY[i] = Long.MIN_VALUE;
            }
        }
        
        long ans = 0;
        for (int i = a; i <= n - b; i++) {
            if (bestX[i] != Long.MIN_VALUE && bestY[i] != Long.MIN_VALUE) {
                ans = Math.max(ans, bestX[i] + bestY[i]);
            }
        }
        
        return ans;
    }
}