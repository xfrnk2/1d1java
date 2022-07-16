package boj.p2k.p2200;

import java.util.Scanner;
public class P2231 {
    private static final Scanner in = new Scanner(System.in);
    public static void main (int n) {

        int answer = search(n);
        System.out.print(answer);
    }
    
    static int search(final int N){
        for (int i = 1; i < N; i++){
            int temp = i;
            int result = 0;
            while (temp > 0){
                result += temp % 10;
                temp /= 10;
            }
            if (result + i == N){
                return i;
            }
        }
        return 0;
    }
}