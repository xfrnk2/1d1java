package boj.p1k.p1100;

import java.util.*;


public class P1100 {  
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		for(int i=0; i<8; i++) {
			String input = sc.next();
			for(int j=0; j<8; j++) {
				if((i+j)%2==0 && input.charAt(j)=='F')ans++;
			}
		}
		System.out.println(ans);
	}
}
