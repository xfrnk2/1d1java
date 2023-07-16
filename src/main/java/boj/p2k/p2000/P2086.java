package boj.p2k.p2000;


import java.io.IOException;
import java.util.Scanner;

public class P2086 {
    static int MOD = 1000000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        long aSum = fibo(a + 1)[0][1];
        long bSum = fibo(b + 2)[0][1];

        long res = (MOD + bSum % MOD - aSum % MOD) % MOD;
        System.out.println(res);
    }


    public static long[][] mulMatrix(long[][] mat1, long[][] mat2) {
        long[][] res = new long[2][2];
        res[0][0] = (mat1[0][0] * mat2[0][0] % MOD + mat1[0][1] * mat2[1][0] % MOD) % MOD;
        res[1][0] = (mat1[0][0] * mat2[0][1] % MOD + mat1[0][1] * mat2[1][1] % MOD) % MOD;
        res[0][1] = (mat1[1][0] * mat2[0][0] % MOD + mat1[1][1] * mat2[1][0] % MOD) % MOD;
        res[1][1] = (mat1[1][0] * mat2[0][1] % MOD + mat1[1][1] * mat2[1][1] % MOD) % MOD;
        return res;
    }

    public static long[][] fibo(long n) {

        if (n == 1) {
            return new long[][]{{1, 1}, {1, 0}};
        }

        long[][] mid = fibo(n / 2);
        return n % 2 == 1 ?
                mulMatrix(fibo(1), mulMatrix(mid, mid))
                : mulMatrix(mid, mid);
    }

}
