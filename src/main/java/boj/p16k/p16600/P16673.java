package boj.p16k.p16600;


import java.util.*;


public class P16673 {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int c=s.nextInt();
        int k=s.nextInt();
        int p=s.nextInt();
        int sum=0;
        for(int i=1;i<=c;i++) sum+=k*i+p*i*i;
        System.out.print(sum);
    }
}
