package boj.p1k.p1200;


import java.io.*;
import java.math.BigInteger;
 
public class P1247 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BigInteger zero = new BigInteger("0");
        for(int i = 0; i < 3; i++) {
            int n = Integer.parseInt(in.readLine());
            BigInteger s = zero;
            for(int j = 0; j < n; j++) {
                BigInteger now = new BigInteger(in.readLine());
                s = s.add(now);
            }
            if(s.compareTo(zero) == 0) {
                System.out.println(0);
            } else if(s.compareTo(zero) == 1) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        }
    }
}
