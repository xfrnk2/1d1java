package boj.p2k.p2900;


import java.io.*;
import java.math.*;
import java.util.*;
 

public class P2965 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        System.out.println(B - A > C - B ? B - A - 1 : C - B - 1);
    }
}
