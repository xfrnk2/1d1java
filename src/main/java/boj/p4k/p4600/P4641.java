package boj.p4k.p4600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class P4641 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        while(true){
            int cnt = 0;
            int i = 0;
            int arr[] = new int[16];
            st = new StringTokenizer(in.readLine());
            while(st.hasMoreTokens()){
                int token = Integer.parseInt(st.nextToken());
                if(token == -1) return;
                arr[i] = token;
                i++;
            }

            Arrays.sort(arr);
            for(int j = 0; j < 16; j++){
                for(int k = j; k < 16; k++){
                    if(arr[j] == 0 || arr[k] == 0) continue;
                    if(arr[k] == arr[j] * 2)
                        cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
