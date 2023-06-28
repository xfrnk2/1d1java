package boj.p5k.p5700;


import java.io.*;


public class P5789 {
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while (n--> 0) {
            String input = in.readLine();
            sb.append((input.charAt(input.length()/2-1)!=input.charAt(input.length()/2)
                      ? "Do-it-Not" :"Do-it") + "\n");
        }
        System.out.println(sb);
    }
}
