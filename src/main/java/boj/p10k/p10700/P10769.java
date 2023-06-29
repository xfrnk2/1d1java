package boj.p10k.p10700;

import java.io.*;


public class P10769 {

	public static void main(String[] args) throws IOException {	
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();

		int happy=0, sad=0;

		for(int i=0; i<str.length()-3; i++) {

			if(str.charAt(i)==':' && str.charAt(i+1)=='-' && str.charAt(i+2)==')')happy+=1;

			else if(str.charAt(i)==':' && str.charAt(i+1)=='-' && str.charAt(i+2)=='(')sad+=1;

		}

		if(happy==0 && sad==0) System.out.println("none");

		else if(happy==sad) System.out.println("unsure");

		else if(happy>sad) System.out.println("happy");

		else System.out.println("sad");

	}

}
