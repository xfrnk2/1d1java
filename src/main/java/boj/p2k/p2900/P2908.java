package boj.p2k.p2900;

import java.util.Scanner;
 
public class P2908 {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());
        B = Integer.parseInt(new StringBuilder().append(B).reverse().toString());
        sc.close();
        
		
		System.out.print(A > B ? A : B);
	
	}
}