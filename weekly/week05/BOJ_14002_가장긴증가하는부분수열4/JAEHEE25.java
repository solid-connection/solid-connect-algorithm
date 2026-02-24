package week05.BOJ_14002_가장긴증가하는부분수열4;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        answer.append(max).append("\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == max) {
                stack.push(arr[i]);
                max--;
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop()).append(" ");
        }

        System.out.println(answer);
    }
}
