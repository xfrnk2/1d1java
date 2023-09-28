package boj.p27k.p27900;

import java.io.*;

public class P27961 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int ans = 0;
        while (n > 3) {
            ans ++;
            n = n / 2 + (n % 2 == 0 ? 0 : 1);
        }
        System.out.println(ans + n);
    }
}
