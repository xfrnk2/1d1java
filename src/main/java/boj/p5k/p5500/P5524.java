package boj.p5k.p5500;



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5524 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            String input = br.readLine();
            sb.append(input.toLowerCase() + "\n");
        }
        System.out.print(sb.toString());
    }
}
