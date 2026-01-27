import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N+1];
        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1]; //dp[i] = i까지 최대로 마실 수 있는 포도주의 양
        for (int i = 1; i <= N; i++) {
            if (i == 1) dp[1] = wines[1];
            else if (i == 2) dp[2] = wines[1] + wines[2];
            else dp[i] = Math.max(dp[i-1], wines[i] + Math.max(dp[i-2], dp[i-3] + wines[i-1]));
        }

        System.out.println(dp[N]);

    }
}
