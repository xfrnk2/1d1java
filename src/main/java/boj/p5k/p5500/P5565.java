package boj.p5k.p5500;


import java.io.*;

public class P5565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		for(int i=0; i < 9; i++) {
			int input = Integer.parseInt(in.readLine());
			n -= input;
		}
		System.out.println(n);
	}

}
