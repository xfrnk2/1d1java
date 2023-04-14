package boj.p11k.p11300;


import java.util.Scanner;
 
public class P11365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            String str = sc.nextLine();
            
            if ("END".equals(str)) break;
            
            System.out.println(new StringBuilder(str).reverse().toString());
        }
    }
}
