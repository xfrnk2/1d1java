package boj.p1k.p1300;

import java.util.*;

public class P1356 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr=sc.next();
        
		int len=arr.length();
		if(1 < len) {
			for(int i=1;i<len;i++) {
				int a=1, b=1;
				for(int j=0;j<i;j++)
					a*=(arr.charAt(j)-'0');
				for(int j=i;j<len;j++)
					b*=(arr.charAt(j)-'0');
				if(a==b) {
					
                    System.out.println("YES");	
					System.exit(0);
				}
			}
		}
		System.out.println("NO");	
	}
}
