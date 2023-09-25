package boj.p3k.p3100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P3101 {

    static long ans = 1;
    static int N, M, x = 1, y = 1;
    static String commands;
    static Map<Character, Integer> di;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static long getVal() {
        long idx = x + y - 1;
        long diff = idx > N ? idx - N : 0;
        diff *= diff;
        return idx % 2 == 1 ?  idx * (idx + 1) / 2 - x + 1 - diff : idx * (idx - 1) / 2 + x - diff;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        commands = in.readLine();


        di = new HashMap<>();
        di.put('U', 0);
        di.put('D', 1);
        di.put('L', 2);
        di.put('R', 3);

        for (int i = 0; i < M; i++) {
            char cur = commands.charAt(i);
            x += dir[di.get(cur)][0];
            y += dir[di.get(cur)][1];
            ans += getVal();
        }
        System.out.println(ans);

    }




}
