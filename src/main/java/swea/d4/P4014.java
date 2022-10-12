import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int N, X;
    static int[][] map;
     
     
    public static boolean checkRow(int row) {
        boolean[][] checked = new boolean[N][N];
        for (int i = 0; i < N - 1; i++) { // 뒤에서 둘째 원소까지 순회
            if (map[row][i + 1] != map[row][i]) { //비교 대상이 같지 않다면 // 행일때
                if (map[row][i+1] > map[row][i]) { // 비교 대상이 더 크면
                    // 직전에 경사로 건설이 가능한지 확인
                    int j = 0; // 현재 idx에서 1식 감소
                    while (j < X) { // 경사로 최대길이만큼
                        if (i - j < 0) return false;// idx 범위를 벗어나면 불가능
                        if (map[row][i+1] - 1 != map[row][i - j]) return false;
                        if (checked[row][i-j]) return false;
                        checked[row][i-j] = true;
                        j++;
                    }
                     
                     
                     
                     
                }
                else if (map[row][i+1] < map[row][i]) { // 비교 대상이 더 작으면
                    int j = 1;
                    while (j <= X) {
                        if (N <=i + j ) return false; // idx 범위를 벗어나면 불가능
                        if (map[row][i+j] != map[row][i] - 1) return false;
                        if (checked[row][i+j]) return false;
                        checked[row][i+j] = true;
                        j++;
                    }
                    //System.out.println(i + "...");
                    i += X - 1;
                    //System.out.println(i + "...");
                }
                //System.out.println(Arrays.toString(map[row]));
            }
            //System.out.println(i);
        }
        return true;
    }
     
     
    public static boolean checkCol(int col) {
        boolean[][] checked = new boolean[N][N];
        for (int i = 0; i < N - 1; i++) { // 뒤에서 둘째 원소까지 순회
            if (map[i + 1][col] != map[i][col]) { //비교 대상이 같지 않다면 // 행일때
                if (map[i+1][col] > map[i][col]) { // 비교 대상이 더 크면
                    // 직전에 경사로 건설이 가능한지 확인
                    int j = 0; // 현재 idx에서 1식 감소
                    while (j < X) { // 경사로 최대길이만큼
                        if (i - j < 0) return false;// idx 범위를 벗어나면 불가능
                        if (map[i+1][col] - 1 != map[i-j][col]) return false;
                        if (checked[i-j][col]) return false;
                        checked[i-j][col] = true;
                        j ++;
                    }
                     
                     
                     
                     
                     
                }
                else if (map[i+1][col] < map[i][col]) { // 비교 대상이 더 작으면
                    int j = 1;
                    while (j <= X) {
                        if (N <=i + j ) return false; // idx 범위를 벗어나면 불가능
                        if (map[i+j][col] != map[i][col] - 1) return false;
                        //System.out.println(i+j);
                        if (checked[i+j][col]) return false;
                        checked[i+j][col] = true;
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
        int T = Integer.parseInt(in.readLine());
        StringTokenizer st;
         
        for (int tc = 1; tc <= T; tc++) {
             
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            int ans = N * 2;
            for (int i = 0; i < N; i++) {
                 
                //가로줄과 세로줄을 동시에 탐색 -> 0~ N-1까지 각각의 행과 열 (2회)
                //System.out.println(i + "...i...");
                //System.out.println("row : " + checkRow(i));
                //System.out.println("col : " + checkCol(i));
                // 6번 테케 정답이 4인데 나는 6이 나오고 있다.
                //가로줄과 세로줄을 동시에 탐색 -> 0~ N-1까지 각각의 행과 열 (2회)
                if (!checkCol(i)) ans --;
                if (!checkRow(i)) ans --;
                 
            }
            System.out.printf("#%d %d\n", tc, ans);
             
             
         
             
        }
         
         
         
         
    }
 
}
