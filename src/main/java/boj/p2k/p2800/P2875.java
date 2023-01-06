package boj.pk2.p2800;


import java.util.*;

public class P2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int t = 0;
        while (n >= 2 && m >= 1 && n + m >= 3 + k) {
            m--;
            n -= 2;
            t++;
        }
        System.out.println(t);
    }
}
