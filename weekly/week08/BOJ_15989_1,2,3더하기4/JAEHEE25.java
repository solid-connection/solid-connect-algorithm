import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //dp[i][j] = i를 만들 때 마지막 숫자가 j이고, 오름차순인 방법의 수
        int[][] dp = new int[10001][4];
        dp[1][1] = 1; //1
        dp[2][1] = 1; //1,1
        dp[2][2] = 1; //2
        dp[3][1] = 1; //1,1,1
        dp[3][2] = 1; //1,2
        dp[3][3] = 1; //3
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        //정답 출력
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int t = Integer.parseInt(br.readLine());
            answer.append(dp[t][1] + dp[t][2] + dp[t][3]).append("\n");
        }
        System.out.println(answer);
    }
}