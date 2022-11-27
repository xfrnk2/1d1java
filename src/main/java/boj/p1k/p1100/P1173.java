package boj.p1k.p1100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1173 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalHealthTime = Integer.parseInt(st.nextToken());
        int initPulse = Integer.parseInt(st.nextToken());
        int thresholdPulse = Integer.parseInt(st.nextToken());
        int increaseInPulsePerMinute = Integer.parseInt(st.nextToken());
        int decreaseInPulsePerMinute = Integer.parseInt(st.nextToken());

        int tt = -1;
        if (thresholdPulse - initPulse >= increaseInPulsePerMinute) {
            tt = 0;
            int currentPulse = initPulse;
            for (int cnt = 0; cnt < totalHealthTime; ) {
                tt++;
                if (currentPulse + increaseInPulsePerMinute <= thresholdPulse) {
                    currentPulse += increaseInPulsePerMinute;
                    cnt++;
                } else {
                    currentPulse -= decreaseInPulsePerMinute;
                    if (currentPulse < initPulse) currentPulse = initPulse;
                }
            }
        }
        System.out.println(tt);
    }

}
