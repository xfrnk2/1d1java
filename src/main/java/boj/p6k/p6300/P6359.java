package boj.p6k.p6300;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P6359 {

	
	
	public static void main(String[] args) {
        
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int k=1; k<=t; k++) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
            
			for(int i=1; i<=N; i++) {
				for(int j=1; i*j<=N; j++) {
					if(arr[i*j]!=0) {
                        arr[i*j]=0;
                    }
					else  {
                        arr[i*j]=1;
                    }
				}
			}
			int ans=0;
			for(int i=1; i<=N; i++) {
				ans+=arr[i];
			}
			System.out.println(ans);
		}
	}

}
