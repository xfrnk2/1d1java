package boj.p7k.p7500;


import java.io.*;
import java.util.*;


public class P7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int height = 10;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                height += 5;
            } else {
                height += 10;
            }
        }
        System.out.print(height);
    }
}
 
