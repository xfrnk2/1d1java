package boj.p4k.p4700;



import java.io.*;


public class P4796 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int num = 0;
		
		while(!str.equals("0 0 0")) {
			num++;
			String arr[] = str.split(" ");
			int L = Integer.parseInt(arr[0]);
			int P = Integer.parseInt(arr[1]);
			int V = Integer.parseInt(arr[2]);
			
			int result = (V / P) * L + Math.min((V % P), L);
			bw.write("Case "+ num +": " + result+"\n" );
			str = br.readLine();
		}
		bw.flush();
	}
}
