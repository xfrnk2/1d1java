package boj.p2k.p2800;


import java.util.*;


public class P2845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c  = a * b;
        int ans = 0;

        for (int i=0; i < 5; i++) {
            int d = sc.nextInt();
            ans = d - c;
            System.out.println(ans);
        }
    }
}
