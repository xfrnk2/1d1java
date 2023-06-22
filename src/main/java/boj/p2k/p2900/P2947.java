package boj.p2k.p2900;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2947 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean flag = false;
            for (int i = 1; i < 5; i++) {
                if (arr[i-1] > arr[i]) {
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    flag = true;
                    for (int j = 0; j < 5; j++) sb.append(arr[j] + " ");
                    sb.append('\n');
                }
            }
            if (!flag) break;
        }
        System.out.print(sb.toString());
    }
}
