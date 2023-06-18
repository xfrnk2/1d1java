package boj.p5k.p5500;


import java.util.*;
import java.io.*;


public class P5533 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        int[] score = new int[n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int sum = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(j==k) continue;
                    if(arr[j][i] != arr[k][i]) sum = arr[j][i];
                    else {sum = 0; break;}
                }
                score[j] += sum;
                sum = 0;
            }
        }
        
        for(int i=0; i<n; i++) {
            System.out.println(score[i]); 
        }
    }
}
