package boj.p1k.p1000;


import java.util.*;
import java.io.*;


public class P1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int xMin = Math.min(x,w-x);
        int yMin = Math.min(y,h-y);

        System.out.println(Math.min(xMin, yMin));
    }
}
