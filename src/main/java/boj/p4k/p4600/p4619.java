package boj.p4k.p4600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4619 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(in.readLine());
			int b = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int num1 = 0;
			int num2 = 0;

			if(b == 0 && N == 0) break;
			
			
			int A = 0;
			while(true) {
				if(Math.pow(A, N) <= b) {
					num1 = A;
				}else if(Math.pow(A, N) > b){
					num2 = A;
					break;
				}
				A++;
			}
    	int result = (Math.abs(Math.pow(num1, N) - b) <= Math.abs(Math.pow(num2, N) - b)) ? num1 : num2;
			
			System.out.println(result);
		}
	}

}