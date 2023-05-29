package boj.p2k.p2700;


import java.util.*;
import java.io.*;


public class P2712 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			Double val = Double.parseDouble(st.nextToken());
			String input = st.nextToken();
			if(input.equals("kg")) {
				System.out.printf("%.04f lb\n", val*2.2046);
			}else if(input.equals("g")) {
				System.out.printf("%.04f l\n", val*3.7854);
			}else if(input.equals("l")) {
				System.out.printf("%.04f g\n", val*0.2642);
			}else if(input.equals("lb")) {
				System.out.printf("%.04f kg\n", val*0.4536);
			}
		}
	}
}
