package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2568 {

	public static class Item {
		int a, b;

		public Item(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Item [a=" + a + ", b=" + b + "]";
		}
		
	}

	static int[][] pair;
	static List<Integer> lis;
	static int[] indicies;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));	
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		pair = new int[N][2];
		lis = new LinkedList<>();
		indicies = new int[N];
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pair[i][0] = a;
			pair[i][1] = b;
			
		}
		Arrays.sort(pair, Comparator.comparingInt(o -> o[0]));
		
		for (int i = 0; i < N; i++) {
			
			if (lis.size() == 0 || lis.get(lis.size()-1) < pair[i][1]) {
				lis.add(pair[i][1]);
				indicies[i] = lis.size() - 1;
			} else {
				int idx = binarySearch(pair[i][1]);
				lis.set(idx, pair[i][1]);
				indicies[i] = idx;
				
			}
		}
		
		out.write(N - lis.size() + "\n");
		
		int idx = lis.size() - 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = N-1; i >= 0; i--) {
			if (indicies[i] == idx) {
				idx --;
			} else {
				stack.push(pair[i][0]);
			}
		}
		
		while (!stack.isEmpty()) {
			out.write(stack.pop() + "\n");
		}
		out.flush();
	}
	
    public static int binarySearch(int num) {
        int l = 0;
        int r = lis.size() - 1;
        
        while(l <= r) {
            int m = (l + r) / 2;
 
            if(lis.get(m) < num) {
                l = m + 1;
            } else{
                r = m - 1;
            }
        }
        return l;
    }
    

}
