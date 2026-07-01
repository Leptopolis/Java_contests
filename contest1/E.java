import java.util.*;
import java.io.*;


public class E {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");

        String l = input[0];
        String r = input[1];

        List<String> bn = generate(r.length());

        int count = 0;
        for(String num : bn){
            if(isInRange(l,r,num)){
                count++;
            } 
        }
        System.out.println(count);
    }

    private static List<String> generate(int max){
        List<String> result = new ArrayList<>();

        for(int len = 1;len <= max;len++){
            for(int digit = 1;digit <= 9;digit++){
                StringBuilder sb = new StringBuilder();
                for(int i = 0;i < len;i++){
                    sb.append(digit);
                }
                result.add(sb.toString());
            }
        }
        return result;
    }

    private static boolean isInRange(String l, String r,String num){
        if(num.length() < l.length() || num.length()  > r.length()) return false;

        if(num.length() == l.length() && num.compareTo(l) < 0) return false;

        if(num.length() == r.length() && num.compareTo(r) > 0) return false;

        return true;

    }
}