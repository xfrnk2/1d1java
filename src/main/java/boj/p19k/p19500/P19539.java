package boj.p19k.p19500;

import java.util.*;

public class P19539 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 
		 int num = 0; 
         int sum = 0;
		 
		 for (int i = 0; i < N; i++) {
			int cur = sc.nextInt();
			sum += cur;
			if(cur% 2 == 1) {
				num++;
			}
		}
		if(sum%3==0 && num<=sum/3) {
			System.out.println("YES");
		}else
			System.out.println("NO");
	}
}
