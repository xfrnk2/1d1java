package boj.p15k.p15800;


import java.util.Scanner;


public class P15873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        
        a = sc.nextInt();
        b = 0;
        
        if (a == 1010){
            System.out.println(20);
        }
        else if (a % 10 == 0){
            a /= 100;
            System.out.println(a+10);
        } else {
            b += a % 10;
            a /= 10;
            System.out.println(a == 10 ? 10 + b : a + b);
        }
    }
}
