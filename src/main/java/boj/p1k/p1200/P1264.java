package boj.p1k.p1200;


import java.io.*;
 
public class P1264 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = in.readLine();
			if(str.equals("#"))
				break;
			str = str.toLowerCase();
			int ans=0;
			for(int i = 0; i<str.length(); i++) {
				char t=str.charAt(i);
				if(t=='a' || t=='e' || t=='i' || t=='o' || t=='u')
					ans++;
			}
			System.out.println(ans);		
		}
	}
}
