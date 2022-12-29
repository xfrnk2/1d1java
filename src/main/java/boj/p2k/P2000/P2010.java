package boj.p2k.P2000;


import java.io.*;
import java.util.*;
 
public class P2010 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> tab = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            tab.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        for(int i : tab) {
            sum += i;
        }
        int result = sum - tab.size() + 1;
        System.out.println(result);
    }
 
}
