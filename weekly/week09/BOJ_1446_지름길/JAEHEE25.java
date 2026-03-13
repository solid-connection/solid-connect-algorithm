package week09.BOJ_1446_지름길;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] shortcut = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shortcut[i][0] = start;
            shortcut[i][1] = end;
            shortcut[i][2] = dist;
        }

        int[] dp = new int[D+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= D; i++) {
            for (int j = 0; j < N; j++) { //지름길 확인
                if (shortcut[j][1] == i) { //해당 위치에 도착하는 지름길이 있을 경우
                    dp[i] = Math.min(dp[i], Math.min(dp[i-1] + 1, dp[shortcut[j][0]] + shortcut[j][2]));
                } else { // 없을 경우
                    dp[i] = Math.min(dp[i], dp[i-1] + 1);
                }
            }
        }
        System.out.println(dp[D]);
    }
}
