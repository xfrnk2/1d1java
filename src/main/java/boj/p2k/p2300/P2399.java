package boj.p2k.p2300;


import java.util.Scanner;

public class P2399 {
    static long ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
		int[] arr = new int[N];
		
		
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		
		for(int i=0; i< N; i++) 
			for(int j=0; j< N; j++) 
				ans += Math.abs(arr[i]-arr[j]);
		
		System.out.println(ans);
	}
}
