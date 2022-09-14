package boj.p16k.p16700;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

public class P16724 {
    static int N, M;
    static int[][] di = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = in.readLine();
            for (int j = 0; j < M; j++) {
                char cur = line.charAt(j);
                map[i][j] = cur == 'L' ? 2 : cur == 'R' ? 3 : cur == 'U' ? 0 : 1;
            }
        }

     
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	if (visited[i][j]) continue;
            	int dirCode= map[i][j];
                int nx = i + di[dirCode][0], ny = j + di[dirCode][1];
                
            	search(i, j, nx, ny);
            }
        }
        System.out.println(cnt);
        
        
        
        

    
}
    
    
    public static boolean search(int sx, int sy, int x, int y) {
    	if (visited[x][y]) return false;
    	visited[x][y] = true;
    	if (x == sx && y == sy) {		
    		cnt ++;
    		return true;
    	}
    
    	int dirCode= map[x][y];
        int nx = x + di[dirCode][0], ny = y + di[dirCode][1];
  
        if (!search(sx, sy, nx, ny)) {        	
        	visited[x][y] = false;
        }
        return false;
    }
    
    
}