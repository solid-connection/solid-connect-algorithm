import java.util.*;

public class Hexeong {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}; // 오, 왼, 위, 아래
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 2배 확대된 맵 생성 (최대 50*2 = 100)
        map = new int[101][101];

        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2, y1 = rec[1] * 2, x2 = rec[2] * 2, y2 = rec[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    // 이미 내부(2)로 판정된 곳은 건드리지 않음
                    if (map[i][j] == 2) continue;
                    
                    // 테두리인 경우 1, 내부인 경우 2
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }

        // 2. BFS 탐색
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    public int bfs(int startX, int startY, int targetX, int targetY) {
        Deque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(startX, startY, 0));
        
        boolean[][] visited = new boolean[101][101];
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            // 목표 도달 시 (2배 확대 상태이므로 거리를 2로 나눔)
            if (cur.x == targetX && cur.y == targetY) {
                return cur.dist / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 맵 범위 안이고, 테두리(1)이며, 방문하지 않은 곳 탐색
                if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Position(nx, ny, cur.dist + 1));
                    }
                }
            }
        }
        return 0;
    }

    static class Position {
        int x, y, dist;
        Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
