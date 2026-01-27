import java.util.*;
class Solution {
    public long solution(String expression) {
        List<String> list = toList(expression); //리스트로 분리

        //우선순위별 계산
        String[] prior = {"*-+", "*+-", "+-*", "+*-", "-*+", "-+*"};
        long answer = 0;
        for (String p : prior) {
            answer = Math.max(getResult(list, p), answer); //해당 우선순위로 계산했을 때의 결과로 최댓값 찾기
        }
        return answer;
    }

    long getResult(List<String> list, String p) {
        Deque<String> dq = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) { //리스트로 덱 초기화
            dq.offerLast(list.get(i));
        }
        dq.offerLast("last"); //마지막 원소임을 표시

        int pi = 0;
        char op = '.'; //.으로 초기화
        while (pi < 3) {
            String val = dq.pollFirst();

            if (val.equals("last")) { //마지막 원소일 경우
                pi++;
                if (dq.size() == 1) { //1개만 남았을 경우 최종 결과 반환
                    return Math.abs(Long.parseLong(dq.pollLast()));
                }
                dq.offerLast("last");
                continue;
            }

            if (op != '.') { //계산
                long num1 = Long.parseLong(dq.pollLast());
                long num2 = Long.parseLong(val);
                long result = calculate(num1, num2, op);
                dq.offerLast(String.valueOf(result)); //연산 결과 삽입
                op = '.';
                continue;
            }

            if (val.charAt(0) == p.charAt(pi)) { //우선순위에 해당하는 연산자라면
                op = val.charAt(0);
            } else {
                dq.offerLast(val);
            }
        }

        return 0;
    }

    long calculate(long num1, long num2, char op) {
        if (op == '*') {
            return num1 * num2;
        } else if (op == '+') {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }

    List<String> toList(String expression) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) { //연산자라면
                list.add(sb.toString());
                sb = new StringBuilder();
                list.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        list.add(sb.toString());
        return list;
    }
}
