package boj.p11k.p11600;


import java.io.*;
import java.util.*;

public class P11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (65 > (int)c || (int)c > 122) {
                sb.append(c);
                continue;
            }
            sb.append(((c <= 90 && c > 77) || (97 <= c && c > 109)) ? (char) (c - 13) : (char) (c + 13));            
        }
        System.out.print(sb);
    }
}
