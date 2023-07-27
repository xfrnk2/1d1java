package boj.p27k.p27200;


import java.util.Scanner;


public class P27294 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int S=sc.nextInt();

        if(T<=11) System.out.println(280);
        else if(T<=16) System.out.println(S == 0 ? 320 : 280);
        else System.out.println(280);
    }
}
