package boj.p10k.p10800;


import java.util.Scanner;

public class P10808 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] cntArr = new int[26];
		for (char c : input.toCharArray()) {
			cntArr[c - 97]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cntArr.length; i++) {
			sb.append(cntArr[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
