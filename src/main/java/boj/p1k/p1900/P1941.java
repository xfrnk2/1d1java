package boj.p1k.p1900;

import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P1941 {
    static int N= 5;
    static int[][] di = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static char[][] map = new char[N][N];
    static boolean[][] visited = new boolean[N][N];
    static Set<String> answers = new HashSet<>();

    static class Pos extends Point implements Comparable<Pos>{
        Pos(int x, int y) {
            super(x, y);

        }
        public int compareTo(Pos o) {
        	if (x - o.x == 0) {
        		return y - o.y;
        	} else {
        		return x - o.x;
        	}
            
        }
		@Override
		public String toString() {
			return String.format("" + x + y);
		}
        
        


    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            map[i] = in.readLine().toCharArray();
        }



        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S') {
                    visited[i][j] = true;
                    ArrayList<Pos> order = new ArrayList<Pos>();
                    order.add(new Pos(i, j));
                    search(order, 1, 1, i, j);
                    visited[i][j] = false;
                }
            }
        }
        System.out.print(answers.size());



    }

    public static boolean isOut (int x, int y) {
        return x < 0 || y < 0 || N <= x || N <= y;
    }


    public static void search(ArrayList<Pos> order, int lee, int cnt, int x, int y) {
        if (cnt == 7) {
            if (4 > lee) return;
            Collections.sort(order);
            System.out.println(order);
            String temp = "";
            for (Pos pos : order) {
				temp += pos;
			}
            answers.add(temp);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + di[i][0], ny = y + di[i][1];
            if (isOut(nx, ny) || visited[nx][ny]) continue;
            visited[nx][ny] = true; 
            
            order.add(new Pos(nx, ny));
            if (map[nx][ny] == 'S') {
            	search(order, lee + 1, cnt + 1, nx, ny);
            } 
            else {
            	search(order, lee, cnt + 1, nx, ny);
            }
            order.remove(order.size()-1);
            visited[nx][ny] = false;
        }

    }

}