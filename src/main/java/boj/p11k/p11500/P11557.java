package boj.p11k.p11500;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T--> 0) {
            int N = Integer.parseInt(br.readLine());
            String[] str = new String[N];
            int[] num = new int[N];

            for (int i = 0 ; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                str[i] = st.nextToken();
                num[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            String ans = "";
            for (int i = 0 ; i < N; i++) {
                if (max < num[i]) {
                    max = num[i];
                    ans = str[i];
                }
            }

            System.out.println(ans);
            
        }
    }
}
