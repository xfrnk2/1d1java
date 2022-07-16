package boj.p4k.p4100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4153 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
        	
            int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] lines = {a, b, c};
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            Arrays.sort(lines);
            
            if (lines[0] * lines[0] + lines[1] * lines[1] == lines[2] * lines[2]) {
            	System.out.println("right");
            } else {
            	System.out.println("wrong");
            }
            
            st = new StringTokenizer(br.readLine());
        }
    }
}
		
		
