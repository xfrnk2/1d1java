package boj.p3k.p3000;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3055 {
	static int R, C;
	static int[][] di = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	static boolean[][] visited;
	static ArrayDeque<Point> waterQ;
	static ArrayDeque<Point> hedgeQ;
	
	
	private static boolean checkIsInvalidRange(int x, int y) {
		return x < 0 || y < 0 || R <= x || C <= y;
	}
	
	private static void waterFlow() {
        int waterSize = waterQ.size(); 
        while(waterSize --> 0) {
        	Point water = waterQ.poll();
        	for (int i = 0; i < 4; i++) {
				int wnx = water.x + di[i][0], wny = water.y + di[i][1];
				if (checkIsInvalidRange(wnx, wny) || map[wnx][wny] == 'D' || map[wnx][wny] == 'X' || map[wnx][wny] == '*') continue;			
				map[wnx][wny] = '*';
				visited[wnx][wny] = true;
				waterQ.offer(new Point(wnx, wny));
			}
        }
	}
	
	private static boolean hedgeMove() {
        int hedgeSize = hedgeQ.size();
        while(hedgeSize --> 0) {
        	Point hedge = hedgeQ.poll();
        	for (int i = 0; i < 4; i++) {
				int hnx = hedge.x + di[i][0], hny = hedge.y + di[i][1];
				if (checkIsInvalidRange(hnx, hny) || map[hnx][hny] == '*' ||  map[hnx][hny] == 'X' || visited[hnx][hny]) continue;
				if (map[hnx][hny] == 'D') return false;			
				visited[hnx][hny] = true;
				hedgeQ.offer(new Point(hnx, hny));
			}
        }
        return true;
	}

	public static void init () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        R = Integer.parseInt(info[0]);
        C = Integer.parseInt(info[1]);
        map = new char[R][C];
        visited = new boolean[R][C];
        waterQ = new ArrayDeque<Point>();
        hedgeQ = new ArrayDeque<Point>();
        
        for (int i = 0; i < R; i++) {
        	String input = br.readLine();
			for (int j = 0; j < C; j++) {
				char cur = input.charAt(j);
				if (cur == '*') {
					waterQ.offer(new Point(i, j));
					visited[i][j] = true;
				} else if (cur == 'S') {
					hedgeQ.offer(new Point(i, j));
					visited[i][j] = true;
					continue;
				} 
				
				map[i][j] = cur;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
	
		init();
        int cnt = 0;
        while (true) {
        	cnt ++;
            if (hedgeQ.size() == 0 && waterQ.size() == 0) {
            	System.out.println("KAKTUS");
            	return;
            }
            waterFlow();
            if (!hedgeMove()) {
            	System.out.println(cnt);
            	return;
            }
        }
        }
        
	
        
        
        
        
        
	

}
