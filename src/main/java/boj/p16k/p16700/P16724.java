import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] board;
    static int[][] markBoard;
    static int count;
    static int n, m;
    static final int nowTraversing = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();

        markAll();

        System.out.println(count);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = pi(st.nextToken());
        m = pi(st.nextToken());

        board = new char[n][m];
        markBoard = new int[n][m];
        count = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }
    }

    private static void markAll() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (markBoard[i][j] == 0) {
                    markBoard[i][j] = traverse(i, j);
                }
            }
        }
    }

    static int traverse(int x, int y) {//dfs라고 보셔도 무방합니다
        if(!valid(x, y) || isLoop(x, y)) {
            return ++count;
        } else if(isMarked(x, y)) {
            return markBoard[x][y];
        } else {
            markBoard[x][y] = nowTraversing;

            int dir = getDir(board[x][y]);
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];
            markBoard[x][y] = traverse(nextX, nextY);

            return markBoard[x][y];
        }
    }

    static boolean isLoop(int x, int y) {
        if (markBoard[x][y] == nowTraversing) {
            return true;
        } else return false;
    }

    static boolean valid(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        else return true;
    }

    static boolean isMarked(int x, int y) {
        if(markBoard[x][y] > 0) return true;
        else return false;
    }

    static int getDir(char c) {
        switch(c) {
            case 'U':
                return 0;
            case 'R':
                return 1;
            case 'D':
                return 2;
            case 'L':
                return 3;
            default:
                System.out.println("wrong character Input");
                return -1;
        }
    }

    public static int pi(String str) {
        return Integer.parseInt(str);
    }

}