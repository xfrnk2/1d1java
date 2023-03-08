package boj.p5k.p5500;


import java.io.*;
import java.util.*;

public class P5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int S = 0;
        int T = 0;
        while (st.hasMoreTokens()) {
            S += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        while (st.hasMoreTokens()) {
            T += Integer.parseInt(st.nextToken());
        }
        System.out.print(Math.max(S,T));
    }
}
