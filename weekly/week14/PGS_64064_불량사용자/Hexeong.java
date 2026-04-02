import java.util.*;
import java.util.regex.*;

class Solution {

    HashSet<HashSet<String>> finalResult = new HashSet<>();
    boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];

        // 패턴 전처리 (* -> .)
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }

        // 탐색 시작 (0번 패턴부터 채우기 시작)
        backtrack(0, user_id, banned_id, new HashSet<>());

        return finalResult.size();
    }

    public void backtrack(int b_idx, String[] user_id, String[] banned_id, HashSet<String> currentSet) {
        // 모든 제재 대상을 다 정했다면 종료
        if (b_idx == banned_id.length) {
            finalResult.add(new HashSet<>(currentSet)); // 현재 조합 저장
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            // 1. 이미 사용 중인 유저면 패스
            if (visited[i]) continue;

            // 2. 패턴 매칭 확인
            if (Pattern.matches(banned_id[b_idx], user_id[i])) {
                visited[i] = true;              // 선택
                currentSet.add(user_id[i]);

                backtrack(b_idx + 1, user_id, banned_id, currentSet); // 다음 칸 채우러 가기

                currentSet.remove(user_id[i]);   // 복구 (백트래킹 핵심)
                visited[i] = false;
            }
        }
    }
}