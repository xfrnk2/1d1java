package boj.p18k.18400;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18436 {

	static int N, M;
	static int[] arr, evenTree;
	
	
	private static int evenInit(int start, int end, int node) {
		if (start == end)
			return evenTree[node] = arr[start] % 2 == 1 ? 0 : 1;
		int mid = (start + end) / 2;
		return evenTree[node] = evenInit(start, mid, node * 2 )+ evenInit(mid + 1, end, node * 2 + 1);
	}
	

	
	
	private static int evenSum(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return 0;
		
		if (left <= start && end <= right) {
			return evenTree[node];
		}
		
		int mid = (start + end) / 2;
		return evenSum(start, mid, node * 2, left, right) + evenSum(mid + 1, end, node * 2 + 1, left, right);
		
		
	}
	
	private static int update(int start, int end, int node, int idx, boolean isEven) {
		if (idx < start || end < idx) {
			return evenTree[node];			
		}
		
		
		if (start == end) {
			return evenTree[node] = isEven ? 1 : 0;
		}
		
		int mid = (start + end) / 2;
		return evenTree[node] = update(start, mid, node * 2, idx, isEven) + 
		update(mid+1, end, node * 2 + 1, idx, isEven);

		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		evenTree = new int[N * 4];
		M = Integer.valueOf(in.readLine());

		evenInit(1, N, 1);

		for (int z = 0; z < M; z++) {
			st = new StringTokenizer(in.readLine());
			int qn = Integer.valueOf(st.nextToken());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			switch (qn) {
				case 1:
					boolean prevIsEven = arr[a] % 2 == 0;
					boolean nextIsEven = b % 2 == 0;
					arr[a] = b;

					if (!prevIsEven && nextIsEven) {
						update(1, N, 1, a, 
								true
								);	
					}
					if (prevIsEven && !nextIsEven) {
						update(1, N, 1, a, 
								false
								);	
					}
					
					

					break;
						
			
				case 2:
					//System.out.println("짝수");
					sb.append(evenSum(1,N, 1, a, b) + "\n");
					break;
				case 3:
					//System.out.println("홀수");
					sb.append((int)(b - a + 1 - evenSum(1,N, 1, a, b)) + "\n");
					break;
			}
		}
		System.out.println(sb.toString());
	}

}
