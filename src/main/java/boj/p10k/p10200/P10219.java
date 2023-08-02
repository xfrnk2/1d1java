package boj.p10k.p10200;


import java.io.*;
import java.util.*;

public class P10219 {
    static int T;
    static int H, W;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        T = Integer.parseInt(in.readLine());
        
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            sb = new StringBuilder();
            
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            
            for(int j=0;j<H;j++){
                String input = in.readLine();
                for(int k=W-1; 0<=k;k--){
                    sb.append(input.charAt(k));
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}
