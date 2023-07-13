package boj.p1k.p1200;


import java.util.*;
 
public class P1267 {
 
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K;
        int y = 0, m = 0;
        for (int i = 0; i < N; i++) {
            K = sc.nextInt();
            
            m += ((K / 60) + 1) * 15;
            y += ((K / 30) + 1) * 10;
 
        }
        System.out.println(y == m ? "Y M " + y : y < m ? "Y " + y : "M " + m);
    }
}
