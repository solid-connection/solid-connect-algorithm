import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long) times[times.length - 1] * n; // 최악의 시간
        long answer = max;

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (int time : times) {
                sum += mid / time; // mid 시간 동안 각 심사관이 처리 가능한 인원 합산
            }

            if (sum >= n) { // n명 이상 처리 가능하면 시간 더 줄여보기
                answer = mid;
                max = mid - 1;
            } else { // n명 처리 못 하면 시간 더 늘리기
                min = mid + 1;
            }
        }
        return answer;
    }
}