package week09.BOJ_25395_커넥티드카실험;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ25395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int S = Integer.parseInt(st1.nextToken());
        Car[] cars = new Car[N + 1];
        boolean[] visit = new boolean[N + 1];

        //초기 위치, 연료 입력
        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cars[i] = new Car(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));
        }

        Queue<Integer> connected = new LinkedList<>();
        connected.offer(S);
        visit[S] = true;
        int minNum = S; //연결된 차 중 가장 작은 번호
        int maxNum = S; //연결된 차 중 가장 큰 번호
        int minPos = cars[S].pos; //이동 가능 범위 minPos ~ maxPos
        int maxPos = cars[S].pos;

        while (!connected.isEmpty()) {
            int nowNum = connected.poll();

            //이동 범위 업데이트
            minPos = Math.min(cars[nowNum].pos - cars[nowNum].fuel, minPos);
            maxPos = Math.max(cars[nowNum].pos + cars[nowNum].fuel, maxPos);

            //왼쪽으로 이동하면서 연결되는 차들 큐에 넣기
            for (int l = minNum - 1; l >= 1; l--) {
                if (minPos > cars[l].pos) break;
                if (!visit[l]) { //갈 수 있는 위치일 경우 연결
                    connected.offer(l);
                    visit[l] = true;
                    minNum = Math.min(minNum, l);
                }
            }

            //오른쪽으로 이동하면서 연결되는 차들 큐에 넣기
            for (int r = maxNum + 1; r <= N; r++) {
                if (cars[r].pos > maxPos) break;
                if(!visit[r]) { //갈 수 있는 위치일 경우 연결
                    connected.offer(r);
                    visit[r] = true;
                    maxNum = Math.max(maxNum, r);
                }
            }
        }

        //출력
        StringBuilder answer = new StringBuilder();
        for (int i = minNum; i <= maxNum; i++) {
            answer.append(i).append(" ");
        }

        System.out.println(answer);
    }

}

class Car {
    int pos;
    int fuel;

    Car(int pos, int fuel) {
        this.pos = pos;
        this.fuel = fuel;
    }
}
