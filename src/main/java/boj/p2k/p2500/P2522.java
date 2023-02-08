package boj.p2k.p2500;


import java.io.*;
import java.util.*;


public class P2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                sb.append(" ");
            }
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= n-1; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= n-i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
