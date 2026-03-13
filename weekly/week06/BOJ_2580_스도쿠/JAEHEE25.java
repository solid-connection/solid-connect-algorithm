package week06.BOJ_2580_스도쿠;
import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ2580 {
    static int N = 9;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0, 0);
    }

    static void sudoku(int x, int y) {
        if (y == N) { //하나의 행 모두 확인
            sudoku(x + 1, 0); //다음 행으로 이동
            return;
        }

        if (x == N) { //모든 칸 확인 -> 출력
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    sb.append(board[i][j]).append(' ');
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0); //하나만 출력해야하기 때문에 시스템 종료
        }

        if (board[x][y] == 0) { //빈칸일 경우
            for (int num = 1; num <= N; num++) { //1~9 중 가능한 수 찾기
                if (checkPossible(x, y, num)) {
                    board[x][y] = num; //가능한 수 빈칸에 넣기
                    sudoku(x, y + 1); //다음 칸 확인
                    board[x][y] = 0; //다시 빈 칸으로 처리
                }
            }
        } else { //빈칸이 아닐 경우 다음 칸 확인
            sudoku(x, y + 1);
        }
    }

    static boolean checkPossible(int x, int y, int value) { //value가 있는지 검사
        //행 검사
        for (int i = 0; i < N; i++) {
            if (board[x][i] == value) {
                return false;
            }
        }

        //열 검사
        for (int i = 0; i < N; i++) {
            if (board[i][y] == value) {
                return false;
            }
        }

        //정사각형 검사
        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;
        for (int i = sx; i < sx + 3; i++) {
    		for (int j = sy; j < sy + 3; j++) {
    			if (board[i][j] == value) {
    				return false;
    			}
    		}
    	}
        return true;
    }

}
