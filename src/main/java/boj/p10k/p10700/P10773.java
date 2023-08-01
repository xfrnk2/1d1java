package boj.p10k.p10700;


import java.util.*;
import java.io.*;


public class P10773 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<K; i++) {
			int input = Integer.parseInt(in.readLine());

			if(input == 0) {
				stack.pop();
			}
			else {
				stack.push(input);
			}
		}

		int ans = 0;
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}

		System.out.println(ans);
	}
}
