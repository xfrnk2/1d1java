package boj.p17k.p17100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;



import java.util.ArrayList;
import java.util.Scanner;

public class P17135 {
	static int[][] map;
	static int n,m,d;
	static int ans=0;
	static ArrayList<Integer> archer=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		d=sc.nextInt();
		map=new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		combination(0,0);	
		System.out.print(ans);
	}
	// 궁수의 위치가 정해지면 공격을 한다 
	private static void simulate() {
		int temp=0;
		int castle=n;
		int[][] map2=new int[n][m]; 
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, map2[i], 0, m);
		}

		while(castle>0) { 
			ArrayList<Integer[]> enemy=new ArrayList<>(); 
		for (int k = 0; k < archer.size(); k++) { 
			int min=Integer.MAX_VALUE;
			int []pos=new int[2]; 
			for (int j = 0; j < m; j++) {
				for(int i=castle-1;i>=0;i--) {
					int diff=Math.abs(castle-i)+Math.abs(archer.get(k)-j);

					if(map2[i][j]==1 && diff<=d) { 
						if(diff<min) { 
							min=diff;
							pos[0]=i;
							pos[1]=j;
						}
						break;
					}
				}
			}
			if(min!=Integer.MAX_VALUE) { 
			enemy.add(new Integer[]{pos[0],pos[1]});
			}
		}	
			for (int i = 0; i < enemy.size(); i++) {
				if(map2[enemy.get(i)[0]][enemy.get(i)[1]]!=0) { 
					temp+=1;
					map2[enemy.get(i)[0]][enemy.get(i)[1]]=0;
				}
			}
			castle-=1; 

		}

		if(temp>ans)ans=temp; 
	}
	
	private static void combination(int cnt,int start) {
		if(cnt==3) {
			simulate();
			return;
		}
		for (int i = start; i < m; i++) {
			archer.add(i);
			combination(cnt+1,i+1);
			archer.remove(archer.size()-1);
		}
	}
	
}


/*
public class P17135_backup {

		// 10시 47분 시작 / 25분만 풀기

	// for combination
	static int N, M, D, R;
	static int[] arr, numbers;
	static boolean[] selected;
	
	// for simulation
	static int ans = 0;
	static int[][] field;
	
	public static class Pos implements Comparable<Pos> {
		int x, y, d;
		public Pos (int x,int y , int d) {
			this.x = x;
			this.y = y;
			this.d = d;
			
		}
		
		@Override
		public int compareTo(Pos o) {
			int dis = this.d - o.d;
			if (dis == 0) {
				return this.y - o.y;
			}
			return dis;
		} 
		
	}
	
	public static class XY {
		int x, y;
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			return (this.x == ((XY)o).x && this.y == ((XY)o).y);
		}
		
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = 3;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		// field init
		field = new int[N][M];
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		
		
		
		arr = new int[N];
		numbers = new int[R];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
		
		combination(M, R);
	}
	
	public static void combination(int cnt, int r) {
		if (r == 0) {
			// 세 명의 궁수의 위치 결정
			System.out.println(Arrays.toString(numbers));
			simulate();
			return;
		}
		if (cnt < r) return;
		
		numbers[r-1] = arr[cnt-1];
		combination(cnt -1, r - 1);
		combination(cnt - 1, r);
	}
	
	public static boolean checkIsOver(int[][] f) {
		for (int[] row : f) {
			for (int col : row) {
				if (col == 1) return false;
			}
		}
		return true;
	}
	
	public static void simulate() {
		
		int[][] curField = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				curField[i][j] = field[i][j];
			}
		}
		int res = 0;
		
		while (!checkIsOver(curField)) {
			ArrayList<Pos> container = new ArrayList<>();
			for (int k = 0; k < 3; k++) { // 궁수 한명 (numbers의 idx)
				
				int archerX = N;
				int archerY = numbers[k];
				Pos curTar = null; 
				
				for (int i = N - 1; i >= N - D; i--) {
					for (int j = 0; j < M; j++) {
						if (curField[i][j] == 1) {
							int dif = Math.abs(archerX - i) + Math.abs(archerY - j);
							if (dif <= D) {
								if (curTar == null) curTar = new Pos(i, j, dif);
								else {
									if (curTar.d > dif) curTar = new Pos(i, j, dif);
									if (curTar.d == dif && curTar.y > j) curTar = new Pos(i, j, dif);
								}
								//container.add(new Pos(i, j, dif));
							}
						}
					}
				}
				if (curTar != null)	container.add(curTar);
			}
			
			Collections.sort(container);
			int cnt = 0;
			HashSet<XY> distinctData = new HashSet<XY>();
			for (Pos pos : container) {
				cnt ++;
				curField[pos.x][pos.y] = 0;
				distinctData.add(new XY(pos.x, pos.y));
				if (cnt >= 3) break;
			}
			res += distinctData.size();
			
			// 한칸씩 아래로 이동하기
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < M; j++) {
					curField[i][j] = curField[i-1][j];
				}
			}
			// 맨 윗줄 0으로 채우기
			for (int i = 0; i < M; i++) {
				curField[0][i] = 0;
			}
			
			System.out.println(res);
			ans = Math.max(ans, res);
			for (XY pos : distinctData) {
				System.out.println(pos.x + ", " + pos.y + ", ");
			}
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(curField[i]));
			}
			System.out.println();
			
			
			
		}
		System.out.println(ans);
	}
}
*/