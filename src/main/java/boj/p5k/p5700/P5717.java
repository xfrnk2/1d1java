package boj.p5k.p5700;


import java.util.*;

public class P5717 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0)
				break;
			System.out.println(a+b);
		}
		sc.close();
	}
}
