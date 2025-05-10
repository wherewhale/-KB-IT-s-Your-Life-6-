package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int gridLength, person, fuel;

    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
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
        int taxiRow = Integer.parseInt(input[0]) - 1;
        int taxiCol = Integer.parseInt(input[1]) - 1;
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

    public static void main(String[] args) throws IOException {
        inputMethod();
    }
}
