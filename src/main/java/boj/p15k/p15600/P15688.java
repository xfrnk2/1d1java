package boj.p15k.p15600;


import java.io.*;
import java.util.*;

public class P15688 {
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
        
    }
}
