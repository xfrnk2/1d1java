package boj.p14k.p14800;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14890 {

	static int N, X;
	static byte[][] map;
	
	
	public static boolean checkRow(int row) {
		boolean[] checkedRow = new boolean[N];

		
		for (int i = 0; i < N - 1; i++) { // 뒤에서 둘째 원소까지 순회
			if (map[row][i + 1] != map[row][i]) { //비교 대상이 같지 않다면 // 행일때
				if (map[row][i+1] > map[row][i]) { // 비교 대상이 더 크면
					// 직전에 경사로 건설이 가능한지 확인
					int j = 0; // 현재 idx에서 1식 감소
					while (j < X) { // 경사로 최대길이만큼
						if (i - j < 0) return false;// idx 범위를 벗어나면 불가능
						if (map[row][i+1] - 1 != map[row][i - j]) return false;
						if (checkedRow[i-j]) return false;
						checkedRow[i-j] = true;
						j++;
					}
					
					
					
					
				}
				else if (map[row][i+1] < map[row][i]) { // 비교 대상이 더 작으면
					int j = 1;
					while (j <= X) {
						if (N <=i + j ) return false; // idx 범위를 벗어나면 불가능
						if (map[row][i+j] != map[row][i] - 1) return false;
						if (checkedRow[i+j]) return false;
						checkedRow[i+j] = true;
						j++;
					}
					i += X - 1;
				}
			}
		}
		return true;
	}
	
	
	public static boolean checkCol(int col) {
		boolean[] checkedCol = new boolean[N];
		for (int i = 0; i < N - 1; i++) { // 뒤에서 둘째 원소까지 순회
			if (map[i + 1][col] != map[i][col]) { //비교 대상이 같지 않다면 // 행일때
				if (map[i+1][col] > map[i][col]) { // 비교 대상이 더 크면
					// 직전에 경사로 건설이 가능한지 확인
					int j = 0; // 현재 idx에서 1식 감소
					while (j < X) { // 경사로 최대길이만큼
						if (i - j < 0) return false;// idx 범위를 벗어나면 불가능
						if (map[i+1][col] - 1 != map[i-j][col]) return false;
						if (checkedCol[i-j]) return false;
						checkedCol[i-j] = true;
						j ++;
					}
					
					
					
					
					
				}
				else if (map[i+1][col] < map[i][col]) { // 비교 대상이 더 작으면
					int j = 1;
					while (j <= X) {
						if (N <=i + j ) return false; // idx 범위를 벗어나면 불가능
						if (map[i+j][col] != map[i][col] - 1) return false;
						if (checkedCol[i+j]) return false;
						checkedCol[i+j] = true;
						j++;
					}
					
					i += X - 1;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	    st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new byte[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Byte.parseByte(st.nextToken());
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			
			if (checkCol(i)) ans ++;
			if (checkRow(i)) ans ++;
			
		}
		System.out.println(ans);
		
		
		
			
		
		
		
		
		
	}

}
