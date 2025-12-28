import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem2146 {

    static int[] DN = {1, -1, 0, 0};
    static int[] DM = {0, 0, 1, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int islandCount = 0;

    static Queue<int[]> island = new LinkedList<>();
    static Queue<int[]> bridge = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] island = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        int minDistance = 300;
        int minStage = 300;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    map[i][j] = 300;
                    visited[i][j] = true;
                } else {
                    map[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }

        island = markIsland(map, n);

        while (!bridge.isEmpty()) {
            int[] cur = bridge.poll();
            int x = cur[0];
            int y = cur[1];
            int islandNum = cur[2];
            int distance = cur[3];

            for (int d = 0; d < 4; d++) {
                int nextX = x + DN[d];
                int nextY = y + DM[d];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = distance + 1;
                        island[nextX][nextY] = islandNum;
                        bridge.add(new int[]{nextX, nextY, islandNum, distance + 1});
                    } else {
                        if (island[nextX][nextY] != islandNum) {
                            if(map[nextX][nextY] == 300) {
                                bw.write(String.valueOf(distance));
                                bw.flush();
                                bw.close();
                                return;
                            }

                            if(minStage >= distance) {
                                minStage = distance;
                                if (minDistance > distance + map[nextX][nextY]) {
                                    minDistance = distance + map[nextX][nextY];
                                }
                            }
                            else {
                                bw.write(String.valueOf(minDistance));
                                bw.flush();
                                bw.close();
                                return;
                            }

                        }
                    }
                }
            }
        }



    }

    public static int[][] markIsland(int[][] map, int n) {
        boolean[][] tempVisited = new boolean[n][n];
        int[][] islandMap = new int[n][n];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                tempVisited[i][j] = false;
                islandMap[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (map[i][j] == 300 && !tempVisited[i][j]){
                    islandCount++;
                    tempVisited[i][j] = true;

                    island.add(new int[]{i, j});
                    while (!island.isEmpty()) {
                        int[] cur = island.poll();
                        int x = cur[0];
                        int y = cur[1];

                        islandMap[x][y] = islandCount;
                        bridge.add(new int[]{x, y, islandCount, 0});

                        for(int d = 0 ; d < 4 ; d++) {
                            int nextX = x + DN[d];
                            int nextY = y + DM[d];

                            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                                if (map[nextX][nextY] == 300 && !tempVisited[nextX][nextY]) {
                                    tempVisited[nextX][nextY] = true;
                                    island.add(new int[]{nextX, nextY});
                                }
                            }
                        }
                    }
                }
            }
        }

        return islandMap;
    }
}