import java.util.Scanner;


public class B{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while(n > 1){
            if(n%2 != 0) n+=1;
            n /= 2;
            count += 1;
        }
        System.out.println(count);
    }
}