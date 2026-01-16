package week02.BOJ_1965_상자넣기;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N]; //dp[인덱스] = 최대 수열의 길이
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i : dp) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
