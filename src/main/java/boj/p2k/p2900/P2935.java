package boj.p2k.p2900;


import java.io.*;
import java.math.*;
import java.util.*;

public class P2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        String input = br.readLine();
        BigInteger b = new BigInteger(br.readLine());
        if (input.equals("*")) {
            System.out.print(a.multiply(b));
        } else {
            System.out.print(a.add(b));
        }
    }
}
