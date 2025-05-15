package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int gridLength, person, fuel;

    static boolean[][] visited;
    static int[] dr = {-1, 0, 0, 1}; // 상, 좌, 우, 하
    static int[] dc = {0, -1, 1, 0};
    static int[][] grid;
    static int[] taxi;
    static int[][] start;
    static HashMap<Integer, int[]> destination = new HashMap<>();

    public static void inputMethod() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        gridLength = Integer.parseInt(st.nextToken());
        person = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        grid = new int[gridLength][gridLength];

        for (int i = 0; i < gridLength; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < gridLength; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1)
                    grid[i][j] = 401;// 벽
            }
        }

        String[] input = reader.readLine().split(" ");
        int taxiRow = Integer.parseInt(input[0]);
        int taxiCol = Integer.parseInt(input[1]);
        taxi = new int[]{taxiRow - 1, taxiCol - 1};

        start = new int[gridLength][gridLength];

        for (int i = 1; i <= person; i++) {
            st = new StringTokenizer(reader.readLine());

            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int departX = Integer.parseInt(st.nextToken()) - 1;
            int departY = Integer.parseInt(st.nextToken()) - 1;

            start[startX][startY] = i; // 승객 위치
            destination.put(i, new int[]{departX, departY}); //목적지 Map
        }
    }

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < gridLength && col >= 0 && col < gridLength && !visited[row][col] && grid[row][col] != 401;
    }
    // 1. 가장 가까운 승객 찾기
    public static int findNearestPassenger(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[gridLength][gridLength];
        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isValid(nr, nc) && !visited[nr][nc]) {
                    if (start[nr][nc] != 0) { // 승객이 있는 위치
                        if (fuel < dist + 1) return -1; // 연료 부족
                        fuel -= dist; // 연료 소모
                        taxi[0] = nr; // 택시 위치 업데이트
                        taxi[1] = nc;
                        int passenger = start[nr][nc]; // 승객 번호
                        start[nr][nc] = 0; // 승객 태움

                        return passenger; // 승객 번호 반환
                    }
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            };
        }

        return -1; // 승객을 찾지 못한 경우
    }


    // 2. 목적지까지 이동
    public static int moveToDestination(int startRow, int startCol, int destRow, int destCol) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[gridLength][gridLength];
        visited[startRow][startCol] = true;
        queue.offer(new int[]{startRow, startCol, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            if (r == destRow && c == destCol) {
                if (fuel < dist + 1) return -1;
                fuel += dist; // 2배 충전 = -dist 후 +2*dist
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isValid(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1; // 도착 실패
    }


    public static void main(String[] args) throws IOException {
        //person : 승객 수
        //fuel : 연료량
        inputMethod();

        // taxi의 위치에서 가장 가까운 승객
        for (int i = 0; i < person; i++) {
            int passenger = findNearestPassenger(taxi[0], taxi[1]);
            if (passenger == -1) {
                System.out.println(-1);
                return;
            }
            // 승객의 목적지
            int[] dest = destination.get(passenger);
            int destRow = dest[0];
            int destCol = dest[1];

            // 승객을 태운 후 목적지까지 이동
            int dist = moveToDestination(taxi[0], taxi[1], destRow, destCol);
            if (dist == -1) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(fuel); // 연료량 출력

    }
}
