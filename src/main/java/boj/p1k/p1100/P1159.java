package boj.p1k.p1100;


import java.util.*;

public class P1159 {
	static int N;
    static int[] alpha;
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		alpha = new int[26];
		
		for(int i = 0; i < N; i++) {
			alpha[sc.next().charAt(0) - 'a']++;
		}
		int t = 0;
		
		for(int i = 0; i < alpha.length; i++) {
			if(alpha[i]>=5) {
				t;
				System.out.printf("%c", i +'a');
			}
		}
		
		if(t == 0)
			System.out.println("PREDAJA");
		
	}
}
