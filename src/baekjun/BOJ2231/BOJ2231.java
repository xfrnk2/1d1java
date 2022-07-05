package baekjun.BOJ2231;

import java.util.Scanner;
public class BOJ2231 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        int answer = search(N);
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