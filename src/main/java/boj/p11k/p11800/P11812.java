package boj.p11k.p11800;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class P11812 {

	static long n;	
    static int k, h, q;

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		

		n = Long.parseLong(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<q; i++) {

			st = new StringTokenizer(in.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			

				sb.append((k == 1 ? Math.abs(x-y) : LCA(x,y))+"\n");

		}

		System.out.println(sb);

	}

	

	static long LCA(long x, long y) {

		long sum = 0;

		

		long a = x == 1 ? 0 : getDepth(x);
		long b = y == 1 ? 0 : getDepth(y);

		

		if(a < b) {

			long temp = x;
			x = y;
			y = temp;
			long depthTemp = a;
			a = b;
			b = depthTemp;

		}

		

		while(a != b) {

			x = getParent(x);
			a = x == 1 ? 0 : getDepth(x);
			sum++;

		}

		

		while(x!=y) {

			x = getParent(x);
			y = getParent(y);
            sum += 2;
		}

		return sum;

	}

	

	static long getParent(long idx) {
		return (idx-2)/k+1;

	}

	

	static long getDepth(long idx) {

		long d = h = 1;

		while(d < idx) {
			 d+= (long)Math.pow(k,h++);
		}

		return h-1;

	}

}
