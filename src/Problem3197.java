import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem3197 {
    public static int[] DR = {1, -1, 0, 0};
    public static int[] DC = {0, 0, 1, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        int[][] visited = new int[r][c];

        int day = 0;

        ArrayDeque<int[]> swan1 = new ArrayDeque<>();
        ArrayDeque<int[]> swan2 = new ArrayDeque<>();
        ArrayDeque<int[]> water = new ArrayDeque<>();

        // 초기화
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'L') {
                    if (swan1.isEmpty()) {
                        swan1.add(new int[]{i, j});
                        visited[i][j] = 1;
                    } else {
                        swan2.add(new int[]{i, j});
                        visited[i][j] = 2;
                    }
                    map[i][j] = '.';
                }
                if (map[i][j] == '.') {
                    water.add(new int[]{i, j});
                }
            }
        }

        // BFS
        while (!water.isEmpty()) {
            int waterSize = water.size();

            while(!swan1.isEmpty()) {
                int[] cur = swan1.poll();

                // 종료 조건
                if (visited[cur[0]][cur[1]] == 2) {
                    bw.write(String.valueOf(day));
                    bw.flush();
                    bw.close();
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nextR = cur[0] + DR[d];
                    int nextC = cur[1] + DC[d];
                    if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                    if (visited[nextR][nextC] == 1) continue;
                    if (visited[nextR][nextC] == 2) {
                        bw.write(String.valueOf(day));
                        bw.flush();
                        return;
                    }

                    if (map[nextR][nextC] == '.') {
                        swan1.add(new int[]{nextR, nextC});
                        visited[nextR][nextC] = 1;
                    }

                }
            }

            while(!swan2.isEmpty()) {
                int[] cur = swan2.poll();

                // 종료 조건
                if (visited[cur[0]][cur[1]] == 1) {
                    bw.write(String.valueOf(day));
                    bw.flush();
                    bw.close();
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nextR = cur[0] + DR[d];
                    int nextC = cur[1] + DC[d];
                    if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                    if (visited[nextR][nextC] == 2) continue;
                    if (visited[nextR][nextC] == 1) {
                        bw.write(String.valueOf(day));
                        bw.flush();
                        return;
                    }

                    if (map[nextR][nextC] == '.') {
                        swan2.add(new int[]{nextR, nextC});
                        visited[nextR][nextC] = 2;
                    }

                }
            }

            // 얼음 녹이기
            for (int i = 0; i < waterSize; i++) {
                int[] cur = water.poll();
                for (int d = 0; d < 4; d++) {
                    int nextR = cur[0] + DR[d];
                    int nextC = cur[1] + DC[d];
                    if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                    if (map[nextR][nextC] == 'X') {
                        map[nextR][nextC] = '.';
                        water.add(new int[]{nextR, nextC});
                    }
                    if ((visited[nextR][nextC] == 1 ||  visited[nextR][nextC] == 2)) continue;
                    if (map[nextR][nextC] != '.') continue;
                    if (visited[cur[0]][cur[1]] == 1 ) {
                        swan1.add(new int[]{nextR, nextC});
                        visited[nextR][nextC] = 1;
                    }
                    if (visited[cur[0]][cur[1]] == 2 ) {
                        swan2.add(new int[]{nextR, nextC});
                        visited[nextR][nextC] = 2;
                    }
                }
            }

            day++;
        }

    }

}