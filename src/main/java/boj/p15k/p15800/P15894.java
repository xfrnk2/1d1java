package boj.p15k.p15800;


import java.math.BigInteger;
import java.util.Scanner;

public class P15894 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger N = new BigInteger(String.valueOf(sc.nextInt()));
        System.out.println(N.multiply(BigInteger.valueOf(4)));
    }
}
