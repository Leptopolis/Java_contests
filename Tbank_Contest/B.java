import java.io.*;


public class B{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if(n % 2 == 0){
            System.out.println("Anya");
        }else{
            System.out.println("Masha");
        }
    } 

}