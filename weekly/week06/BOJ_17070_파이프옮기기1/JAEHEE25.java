package week06.BOJ_17070_파이프옮기기1;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ17070 {
    static final int WALL = 1;
    static int answer = 0;
    static int N;
    static int[][] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(0, 1, 'H'); //0,1에서 시작
        System.out.println(answer);
    }

    static void move(int x, int y, char dir) {
        //각 dir에 따라 갈 방법이 없으면 return
        if (dir == 'H' || dir == 'V') {
            if (!isPossible(x, y) || house[x][y] == WALL) {
                return;
            }
        } else {
            if (!isPossible(x, y) || !isPossible(x-1, y) || !isPossible(x, y-1) ||
                   house[x][y] == WALL || house[x-1][y] == WALL || house[x][y-1] == WALL) {
                return;
            }
        }

        if (x == N - 1 && y == N - 1) { //도착
            answer++;
            return;
        }

        if (dir == 'H') { //가로 이동
            move(x, y+1, 'H'); //1번
            move(x+1, y+1, 'D'); //2번

        } else if (dir == 'V') { //세로 이동
            move(x+1, y, 'V'); //1번
            move(x+1, y+1, 'D'); //2번

        } else { //대각선 이동
            move(x, y+1, 'H'); //1번
            move(x+1, y, 'V'); //2번
            move(x+1, y+1, 'D'); //3번
        }

    }

    static boolean isPossible(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
