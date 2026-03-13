package week04.BOJ_1946_신입사원;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score, (o1, o2) -> o1[0] - o2[0]); //서류 순위 기준 정렬

            int cnt = 0;
            int min = 100001;
            for (int i = 0; i < N; i++) {
                if (score[i][1] < min) {
                    cnt++;
                    min = score[i][1];
                }
            }
            answer.append(cnt).append("\n");
        }

        System.out.println(answer);
    }
}
