package boj.p1k.p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class P1039 {

    static int N, K;
    static int ans = -1; 
	
    static class Info {
        int num;
        int cnt;
    	
        public Info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Info> q = new LinkedList<>();
        boolean[][] visited = new boolean[1000001][K + 1];
		
        q.add(new Info(N, 0));
        visited[N][0] = true;
		
        while (!q.isEmpty()) {
            Info t = q.poll();
			
        
            if (t.cnt == K) {
                ans = Math.max(ans, t.num);
                continue;
            }
			
            int len = String.valueOf(t.num).length();
			
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int next = swap(t.num, i , j);
					
                    if (next != -1 && !visited[next][t.cnt + 1]) {
                        q.add(new Info(next, t.cnt + 1));
                        visited[next][t.cnt + 1] = true;
                    }
                }
            }
        }
        System.out.println(ans);
		
    }
	

    public static int swap(int n, int i, int j) {
        char[] numArr = String.valueOf(n).toCharArray();
	
        if (i == 0 && numArr[j] == '0') {
            return -1;
        }
		
        char tmp;
        tmp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = tmp;
		
        return Integer.parseInt(new String(numArr));
    }

}
