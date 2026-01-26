package week03.BOJ_14503_로봇청소기;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ14503 {
    static int answer = 0;
    static int N;
    static int M;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0}; //북동남서
    static int[] dy = {0, 1, 0, -1};
    static final int DIRTY = 0;
    static final int WALL = 1;
    static final int CLEANED = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(rx, ry, d);
        System.out.println(answer);
    }

    static void clean(int rx, int ry, int d) {
        if (room[rx][ry] == DIRTY) { //현재 칸 청소
            room[rx][ry] = CLEANED;
            answer++;
        }

        if (hasDirty(rx, ry)) { //주변 4칸에 청소되지 않은 칸이 있다면
            int nd = d == 0 ? 3 : d - 1; //반시계 방향으로 90도 회전
            int nx = rx + dx[nd];
            int ny = ry + dy[nd];
            if (isValid(nx, ny) && room[nx][ny] == DIRTY) {
                clean(nx, ny, nd);
            } else {
                clean(rx, ry, nd);
            }

        } else { //없다면
            //후진했을 때 좌표
            int nx = rx + (-1) * dx[d];
            int ny = ry + (-1) * dy[d];
            if (isValid(nx, ny) && room[nx][ny] != WALL) {
                clean(nx, ny, d);
            } else {
                return;
            }
        }
    }

    static boolean hasDirty(int rx, int ry) {
        for (int i = 0; i < 4; i++) {
            int nx = rx + dx[i];
            int ny = ry + dy[i];
            if (isValid(nx, ny) && room[nx][ny] == DIRTY) {
                return true;
            }
        }
        return false;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}
