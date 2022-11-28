package boj.p2k.p2700;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2720 {
    private static final int[] coins = {25, 10, 5, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int remain = Integer.parseInt(br.readLine());
            for (int i = 0; i < coins.length; i++) {
                sb.append(remain/coins[i]).append(' ');
                remain%=coins[i];
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
