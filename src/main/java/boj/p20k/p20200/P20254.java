package boj.p20k.p20200;


import java.util.Scanner;

public class P20254 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Ur = sc.nextInt();
        int Tr = sc.nextInt();
        int Uo = sc.nextInt();
        int To = sc.nextInt();
        System.out.print(56*Ur + 24*Tr + 14*Uo + 6 *To);
    }
}
