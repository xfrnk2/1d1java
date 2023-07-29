package boj.p9k.p9900;


import java.io.*;
import java.util.*;

public class P9933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet(); 
        String ans = "";
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine(); 
            set.add(s);
            StringBuilder sb = new StringBuilder(s);
            String ret = sb.reverse().toString(); 

            if (set.contains(ret)) { 
                ans = ret.length() + " " + ret.charAt(ret.length() / 2);
                break;
            }
        }
        System.out.println(ans);
    }
}
