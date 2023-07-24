package boj.p10k.p10100;


import java.util.*;


public class P10162 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int a, b, c;
        String ans = "-1";
        a = b = c = 0;
		if (t % 10 == 0) {
			a = t / 300;
			t %= 300;

			b = t / 60;
			t %= 60;

			c = t / 10;
			
			ans = a + " " + b + " " + c;
		}
        System.out.println(ans);
	}
}
