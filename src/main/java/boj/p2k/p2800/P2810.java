package boj.p2k.p2800;


import java.io.*;


public class P2810 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String input = in.readLine();

        int cnt = 1;
        for(int i=0;i<N;i++) {
        	char c = input.charAt(i);
        	
        	if(c=='S') cnt++;
        	
        	else if(c=='L') {
        		i++;
        		cnt++;
        	}
        }
        System.out.println(cnt > N ? N : cnt);
    }
}
