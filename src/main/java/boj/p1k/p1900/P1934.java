package boj.p1k.p1900;


import java.util.*;


public class P1934 {
    
    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a * b / gcd(a, b));
        }
    }
}
