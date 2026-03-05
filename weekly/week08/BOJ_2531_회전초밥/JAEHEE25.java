package week08.BOJ_2531_회전초밥;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] plates = new int[N];
        for (int i = 0; i < N; i++) {
            plates[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> sushi = new HashMap<>();
        //처음 k개의 접시
        for (int i = 0; i < k; i++) {
            sushi.put(plates[i], sushi.getOrDefault(plates[i], 0) + 1);
        }

        int start = 0;
        int end = k;
        int answer = sushi.size();
        if (!sushi.containsKey(c)) answer++;

        while (start < N - 1) {
            //이전 스시 빼기
            if (sushi.get(plates[start]) == 1) { //1개 남았다면 아예 삭제
                sushi.remove(plates[start]);
            } else {
                sushi.put(plates[start], sushi.get(plates[start]) - 1);
            }

            if (end >= N) end %= N; //원형 벨트
            sushi.put(plates[end], sushi.getOrDefault(plates[end], 0) + 1); //다음 초밥 넣기

            int cnt = sushi.size();
            if (!sushi.containsKey(c)) {
                cnt++;
            }
            answer = Math.max(answer, cnt);

            start++;
            end++;

        }
        System.out.println(answer);
    }
}
