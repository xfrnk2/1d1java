package boj.p3k.p3000;

import java.io.*;
import java.util.*;

public class P3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> x = new HashMap<>(); 
        Map<Integer, Integer> y = new HashMap<>();  
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            x.put(a, x.getOrDefault(a, 0) + 1);
            y.put(b, y.getOrDefault(b, 0) + 1);
        }
        for (int i : x.keySet()) {
            if (x.get(i) == 1) sb.append(i + " ");
        }
        for (int i : y.keySet()) {
            if (y.get(i) == 1) sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
