import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //요청 시각 기준 정렬

        PriorityQueue<Job> waitQueue = new PriorityQueue<>(); //대기 큐

        int totalTime = 0;
        int ji = 0; //jobs 인덱스
        int time = 0; //현재 시간
        int endCnt = 0; //종료한 작업 수

        while (endCnt < jobs.length) {
            //현재 시간 전까지의 작업 모두 대기 큐에 삽입
            while (ji < jobs.length && jobs[ji][0] <= time) {
                waitQueue.add(new Job(ji, jobs[ji][0], jobs[ji][1]));
                ji++;
            }

            //대기 큐에서 꺼내서 작업 시작
            if (!waitQueue.isEmpty()) {
                Job job = waitQueue.poll();
                time += job.processTime;
                totalTime += (time - job.requestTime);
                endCnt++;
            } else {
                time = jobs[ji][0]; //처리할 작업이 없으면 다음 작업 요청 시간으로 이동
            }
        }

        return totalTime / jobs.length;
    }
}

class Job implements Comparable<Job> {
    int num;
    int requestTime;
    int processTime;

    Job(int num, int requestTime, int processTime) {
        this.num = num;
        this.requestTime = requestTime;
        this.processTime = processTime;
    }

    @Override
    public int compareTo(Job o) {
        //소요시간이 짧은 것 -> 요청 시각이 빠른 것 -> 번호가 작은 것
        if (this.processTime == o.processTime) {
            if (this.requestTime == o.requestTime) {
                return this.num - o.num;
            }
            return this.requestTime - o.requestTime;
        }
        return this.processTime - o.processTime;
    }
}
