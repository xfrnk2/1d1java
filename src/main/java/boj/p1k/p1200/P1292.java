package boj.p1k.p1200;


import java.util.ArrayList;
import java.util.Scanner;


public class P1292 {
    static ArrayList<Integer> li;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        li = new ArrayList<Integer>();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum=0;

        for(int i=0; i<1000; i++) {
            for(int j=0; j<=i; j++) {
                li.add(i + 1); 
            }
        }

        for(int i=a-1; i<=b-1; i++) {
            sum += li.get(i);
        }

        System.out.println(sum);
    }
}
