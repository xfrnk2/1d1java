package boj.p10k.p10100;


import java.util.*;


public class P10156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a*b < c) {
            System.out.println(0);
        } else {
            System.out.println(a * b - c);
        }
    }
}
