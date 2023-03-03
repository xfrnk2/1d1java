package boj.p5k.p5500;


import java.util.*;

public class P5554 {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int res = 0;
		
		for(int i=0;i<4;i++) {
			res += sc.nextInt();
		}
        
        int sec = res % 60;
		int min = res / 60;

		
		System.out.println(min);
		System.out.println(sec);
	}
}
