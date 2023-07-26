package boj.p9k.p9600;


import java.io.*;
import java.util.*;


public class P9506 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            if(n == -1) break;
            
            int sum = 0;
            for(int i=1; i<n; i++) {
                if(n % i == 0) {
                    sb.append(i + " + ");
                    sum += i;
                }
            }
            System.out.println(n + (n == sum ? " = " + sb.toString().substring(0, sb.length() - 3) : " is NOT perfect."));
        }
    }
}
