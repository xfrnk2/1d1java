package programmers;


import java.util.*;

class P92344 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] nb = new int[board.length + 1][board[0].length + 1];
   
        
        for(int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            nb[r1][c1] += type == 2 ? degree : -degree;
            nb[r2 + 1][c1] += type == 2 ? -degree : degree;
            nb[r1][c2 + 1] += type == 2 ? -degree : degree;
            nb[r2 + 1][c2 + 1] += type == 2 ? degree : -degree;
        }
        
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                nb[i][j+1] += nb[i][j];
                
            }
        }
        for(int j=0; j < board[0].length; j++) {
            for(int i=0; i < board.length; i++) {
                nb[i + 1][j] += nb[i][j];
            }
        }
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                board[i][j] += nb[i][j];
                if (board[i][j] > 0) answer ++;
            }
        }
        
        
        return answer;
    }
}
