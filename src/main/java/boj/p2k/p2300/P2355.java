package boj.p2k.p2300;

import java.util.Scanner;


public class P2355 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println(sigma(A, B));

    }

    public static Long sigma(long A, long B){
        return A>=B ? (A+B)*(A-B+1) / 2 : (B+A)*(B-A+1) / 2;
    }
}
