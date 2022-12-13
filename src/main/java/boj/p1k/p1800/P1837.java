package boj.p1k.p1800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1837 {

    final static int SQRT_PRIME_LIMIT = 10000;


    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final boolean[] isPrime = findPrimeNumbers(SQRT_PRIME_LIMIT);
        String result = "GOOD";
        String pNumStr = st.nextToken();
        String kNumStr = st.nextToken();


        final BigInteger pNum = new BigInteger(pNumStr);
        final int kNum = Integer.parseInt(kNumStr);

        for (int i = 2; i < kNum; i++) {
            if (isPrime[i] && (pNum.remainder(BigInteger.valueOf(i)).compareTo(BigInteger.valueOf(0)) == 0)) {
                result = "BAD " + i;
                break;
            }
        }


        System.out.print(result);
    }

    private static boolean[] findPrimeNumbers(int sqrtPrimeLimitNum) {
        int PrimeLimitNum = sqrtPrimeLimitNum * sqrtPrimeLimitNum;
        final boolean[] isPrime = new boolean[PrimeLimitNum];
        Arrays.fill(isPrime, Boolean.TRUE);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= sqrtPrimeLimitNum; i++) {
            if (!isPrime[i]) continue;
            for (int j = i; j < PrimeLimitNum; j += i) {
                if (isPrime[j] && i != j) isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
