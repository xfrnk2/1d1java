package boj.p2k.p2400;


import java.util.*;
import java.lang.Math;

public class P2435 {

    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] temp=new int[103];
		int n = sc.nextInt();
		int k = sc.nextInt();
        int res = Integer.MIN_VALUE;
        
		for(int i=0;i<n;i++)
			temp[i]=sc.nextInt();
		
		for(int i=0;i<=n-k;i++) {
			int sum=0;
			for(int j=0;j<k;j++)
				sum+=temp[i+j];

			res = Math.max(res, sum);
		}
		System.out.println(res);
	}
}
