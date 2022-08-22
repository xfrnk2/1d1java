import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;


public class P3025 {
	static int R, C;
	static char[][] map;
	static ArrayDeque<Pos>[] colPathArr;
	 
	
	public static class Pos {
		int x, y;
		public Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// input을 받기 위한 BufferedReader와 StringTokenizer
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 



		// 변수 R, C와 이에 따른 map의 초기화
		String[] info = br.readLine().split(" ");
		R = Integer.parseInt(info[0]);
		C = Integer.parseInt(info[1]);
		map = new char[R][C];
		colPathArr = new ArrayDeque[C];
		
		for (int i = 0; i < colPathArr.length; i++) {
			colPathArr[i] = new ArrayDeque<>();

		}
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int col = Integer.parseInt(br.readLine()) - 1;
				while (!colPathArr[col].isEmpty() && map[colPathArr[col].peek().x][colPathArr[col].peek().y] == 'O') colPathArr[col].pop();
					
				if (colPathArr[col].isEmpty())	fall(0, col, col);
				else fall(colPathArr[col].peek().x, colPathArr[col].peek().y, col);
			}
		
		
		// map의 최종 상태 출력
		for (char[] row : map) {
			for (char colElem : row) {
				bw.write(colElem);
			}
			bw.write("\n");
		}
		
		bw.flush();
		}
		

//	// 전체 Map의 범위를 벗어나는지 아닌지를 확인하는 함수이다.
	public static boolean checkIsValidRange(int x, int y) {
		return 0 <= x && 0 <= y && x < R && y < C;
	}

	public static void fall(int x, int y, int col) {
		while (x + 1< R && map[x+1][y] != 'X') {
		            if (map[x + 1][y] != 'O') {
		            	x++;
			            colPathArr[col].push(new Pos(x, y));
			            continue;
		            }

	                if (checkIsValidRange(x + 1, y - 1) && map[x + 1][y - 1] == '.' && map[x][y-1] == '.') {
	                    x++;
	                    y--;
	                    continue;
	                }

	                if (checkIsValidRange(x + 1, y + 1) && map[x + 1][y + 1] == '.' && map[x][y+1] == '.') { 
	                	x++;
	                    y++;
	                    continue;
	                }
	                break;
		            }
		        map[x][y] = 'O';
		}

		
		
		
	


}
