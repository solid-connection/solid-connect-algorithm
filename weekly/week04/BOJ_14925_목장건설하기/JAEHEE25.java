package week04.BOJ_14925_목장건설하기;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ14925 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] land = new int[M][N];
        int[][] dp = new int[M+1][N+1];
        int L = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (land[i-1][j-1] == 0) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1; //위, 왼쪽, 왼쪽 위
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        System.out.println(answer);
    }
}
