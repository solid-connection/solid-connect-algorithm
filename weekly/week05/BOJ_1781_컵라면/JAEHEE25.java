package week05.BOJ_1781_컵라면;
import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] works = new int[N][2]; //데드라인, 컵라면 수
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(works, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //푼 문제의 컵라면 수 저장
        for (int i = 0; i < N; i++) {

            //pq 사이즈 == 푼 문제 수 == 사용한 시간과 데드라인 시간 비교
            if (pq.size() < works[i][0]) {
                pq.offer(works[i][1]);
            } else {
                if (pq.peek() < works[i][1]) { //기존에 풀었던 문제의 컵라면 수보다 크면 교체
                    pq.poll();
                    pq.offer(works[i][1]);
                }
            }
        }

        //출력
        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
