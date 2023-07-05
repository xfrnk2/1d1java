package boj.p1k.p1000;


import java.io.*;
import java.util.*;
import java.math.BigInteger;


public class P1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a % 10 == 0) {
                sb.append(10).append("\n");
                continue;
            }
            
            int num = a % 10;
            for (int j = 1; j < b; j++) {
                num = (num * a) % 10;
            }
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}
