package.boj.p2k.p2900;

import java.io.*;
import java.util.*;

public class P2914 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int avg = scanner.nextInt();

       
        System.out.println((avg - 1) * cnt + 1);
    }
}
