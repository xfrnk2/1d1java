package boj.p12k.p12000;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P12904 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb1 = new StringBuilder(in.readLine());
		StringBuilder sb2 = new StringBuilder(in.readLine());
		N = sb1.length();

		while (sb2.length() > N) {
			char lastest = sb2.charAt(sb2.length() - 1);
			sb2.deleteCharAt(sb2.length() - 1);
			if (lastest == 'B') {
				sb2.reverse();
			}
		}
		System.out.println(sb2.toString().equals(sb1.toString()) ? 1 : 0);
	}

}
