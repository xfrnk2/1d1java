package boj.p5k.p5500;


import java.io.*;
import java.util.*;


public class P5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int burdger = Integer.parseInt(in.readLine());
        for (int i = 0; i < 2; i++) {
            burdger = Math.min(burdger, Integer.parseInt(in.readLine()));
        }
        int drink = Math.min(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()));
        System.out.print(burdger + drink - 50);
    }
}
