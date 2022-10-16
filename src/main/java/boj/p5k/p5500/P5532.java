package boj.p5k.p5500;

import java.util.*;
public class P5532 {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int l=s.nextInt();
        int a=s.nextInt();
        int b=s.nextInt();
        int c=s.nextInt();
        int d=s.nextInt();
        int sum=0;
        int sum1=0;
        if(a%c==0) sum=a/c;
        else sum=a/c+1;
        if(b%d==0) sum1=b/d;
        else sum1=b/d+1;
        System.out.println(Math.min(l-sum,l-sum1));
    }
} 