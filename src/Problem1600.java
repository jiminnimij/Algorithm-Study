import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem1600 {
    static int[] dxMonkey = {1, -1, 0, 0};
    static int[] dyMonkey = {0, 0, 1, -1};
    static int[] dxHorse = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dyHorse = {1, 2, 2, 1, -1, -2, -2, -1};

    static final int MAX = 400;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][][] visited = new boolean[h][w][k + 1];


        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        int answer = -1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int kUsed = cur[2];
            int dist = cur[3];

            if (x == h - 1 && y == w - 1) {
                answer = dist;
                break;
            }

            if (kUsed < k) {
                for (int i = 0; i < 8; i++) {
                    int nextX = x + dxHorse[i];
                    int nextY = y + dyHorse[i];

                    if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && map[nextX][nextY] == 0 && !visited[nextX][nextY][kUsed+1]) {
                        visited[nextX][nextY][kUsed + 1] = true;
                        q.add(new int[]{nextX, nextY, kUsed + 1, dist + 1});
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dxMonkey[i];
                int nextY = y + dyMonkey[i];

                if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && map[nextX][nextY] == 0 && !visited[nextX][nextY][kUsed]) {
                    visited[nextX][nextY][kUsed] = true;
                    q.add(new int[]{nextX, nextY, kUsed, dist + 1});

                }
            }
        }


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}