package baekjun.bruteforce.BOJ2503;
import java.util.Scanner;

import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
        scanner.close();
    }
        public static int solution(int num){

            return num * 2;
        }
}