package boj.p1k.p1100;


import java.util.*;

public class P1145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int cnt = 0;
        int v = 1;
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        while (true) {
            for (int k = 0; k < 5; k++) {
                if (v % arr[k] == 0) cnt++;
            }
            if (3 <= cnt) {
                System.out.println(v);
                return;
            }
            v++;
            cnt = 0;
        }

    }
}
