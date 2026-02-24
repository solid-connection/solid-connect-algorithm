package week06.PGS_요격시스템;

import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[0] - o2[0]);

        int start = -1; //현재 요격 미사일의 범위
        int end = 100_000_001;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= end) {
                answer++;
                start = -1;
                end = 100_000_001;
            }
            start = Math.max(start, targets[i][0]);
            end = Math.min(end, targets[i][1]);
        }

        answer++;
        return answer;
    }
}
