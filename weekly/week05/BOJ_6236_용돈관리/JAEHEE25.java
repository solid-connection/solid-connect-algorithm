package week05.BOJ_6236_용돈관리;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] money = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(money[i], max); //최대 금액을 최솟값으로 설정
        }

        int answer = 0;
        int left = max;
        int right = 10000 * 100000;
        while (left <= right) {
            int K = (left + right) / 2;

            //결과 계산
            int result = getWithdrawCnt(money, K, M);

            if (M >= result) {
                answer = K;
                right = K - 1;
            } else {
                left = K + 1;
            }
        }
        System.out.println(answer);
    }

    static int getWithdrawCnt(int[] money, int K, int M) {
        int withdrawCnt = 1;
        int now = K;
        for (int i = 0; i < money.length; i++) {
            if (money[i] > now) { //모자라면 K원 인출
                withdrawCnt++;
                now = K;
            }
            now -= money[i];
        }
        return withdrawCnt;
    }
}
