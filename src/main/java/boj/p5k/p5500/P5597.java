package boj.p5k.p5500;

import java.util.Scanner;

public class P5597 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean[] attendance = new boolean[31];
		for (int i = 0; i < 28; i++) {
			attendance[Integer.parseInt(sc.nextLine())] = true;
		}
		for (int i = 1; i < 31; i++) {
			if (!attendance[i]) {
				System.out.println(i);
			}
		}
	}

}
