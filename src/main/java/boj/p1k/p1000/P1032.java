package boj.p1k.p1000;


import java.io.*;
import java.util.*;


public class P1032 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char[] res = input.toCharArray();
	
        for(int i = 0 ; i < N - 1 ; i++) {
            input = br.readLine();
            for(int j = 0 ; j < input.length() ; j++) {
                if(res[j] != '?' &&  res[j] != input.charAt(j)) {
                        res[j] = '?';
                }
            }
        }
		System.out.println(res);
	}
}
