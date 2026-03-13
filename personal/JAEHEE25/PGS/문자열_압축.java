import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = 1; //단위
        int N = s.length();

        while (len <= N) {
            StringBuilder resultBuilder = new StringBuilder();
            StringBuilder wordBuilder = new StringBuilder();
            String prev = "";
            String word = "";
            int cnt = 0;
            for (int i = 0; i <= N; i++) {
                word = wordBuilder.toString();
                if (word.length() == len) {
                    if (prev.equals("")) { //맨 처음일 경우 prev에 저장
                        prev = word;
                        cnt++;
                    } else if (prev.equals(word)) { //연속된 단어일 경우 개수 카운트
                        cnt++;
                    } else { //새로운 단어일 경우 이전 단어 기록
                        if (cnt <= 1) resultBuilder.append(prev);
                        else resultBuilder.append(cnt + prev);
                        prev = word;
                        cnt = 1;
                    }
                    wordBuilder = new StringBuilder(); //초기화
                }
                if (i < N) wordBuilder.append(s.charAt(i));
            }

            //마지막 처리
            if (cnt <= 1) resultBuilder.append(prev);
            else resultBuilder.append(cnt + prev);
            resultBuilder.append(wordBuilder.toString()); //남은 글자들

            //정답 구하기
            answer = Math.min(resultBuilder.length(), answer);
            len++;
        }

        return answer;
    }
}
