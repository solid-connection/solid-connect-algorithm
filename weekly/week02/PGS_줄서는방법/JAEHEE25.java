package week02.PGS_줄서는방법;

import java.util.*;

class Solution {
    static long[] factorial;

    public int[] solution(int n, long k) {
        //1 ~ n 숫자 리스트
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        //팩토리얼 결과 배열
        factorial = new long[n + 1];
        getFactorialArr(n);

        //정답 배열 구하기
        int num = n;
        int[] answer = new int[n];
        int idx = 0;

        while (n > 1) {
            long blockCnt = factorial[n-1]; //한 블록의 개수
            int q = (int) (k / blockCnt);
            int order = k % blockCnt == 0 ? q : q + 1; //몇 번째 블록인지

            answer[idx++] = list.remove((int) (order - 1)); //order번째 수 제거 + 답 저장
            k -= (order - 1) * blockCnt; //이전까지의 블록 개수만큼 제거
            n--;
        }

        answer[num-1] = list.get(0);
        return answer;
    }

    void getFactorialArr(int n) {
        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
    }
}
