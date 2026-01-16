package week02.BOJ_15486_퇴사2;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            T[i] = t;
            P[i] = p;
        }

        int max = 0;
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
            if (i + T[i] <= N) { //기간 초과 제외
                dp[i + T[i]] = Math.max(P[i] + max, dp[i + T[i]]);
            }
        }

        System.out.println(Math.max(dp[N], max));
    }
}
