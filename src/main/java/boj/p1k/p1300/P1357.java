package boj.p1k.p1300;


import java.util.Scanner;


public class P1357 {
	
	private static int cal(int n) {
       int r = 0;
        while (n > 0) {
            r =  n % 10 + r * 10;
            n /= 10;
        }
       return r; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
        System.out.println(cal(cal(x) + cal(y)));
	}
}
