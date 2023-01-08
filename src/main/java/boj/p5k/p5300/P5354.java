package boj.p5k.p5300;


import java.util.*;
import java.io.*;


public class P5354 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            for (int t = 0; t < M; t++) {
                for (int j = 0; j < M; j++) {
                    if (j + 1 < M && j != 0 && t + 1 < M && t != 0) {
                        bw.write("J");
                    }
                    else {
                        bw.write("#");
                    }
                }
                bw.write("\n");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
