package boj.p2k.p2000;


import java.io.*;

public class P2033 {

	public static void main(String[] args) throws NumberFormatException, IOException {		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		int n = Integer.parseInt(br.readLine());

		

		int x = 1;

		int result = n;

		

		while(n > 0) {

			result = (int)((result / (double)x) + 0.5) * x;

			x *= 10;

			n /= 10;

		}

		

		System.out.println(result);

	}

}
