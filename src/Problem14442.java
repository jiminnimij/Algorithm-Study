import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Problem14442 {
    static int[] DN = {1, -1, 0, 0};
    static int[] DM = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][][] visited = new boolean[n][m][k+1];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0 ; i < n ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(line.charAt(j) + "");
                Arrays.fill(visited[i][j], false);
            }
        }

        visited[0][0][0] = true;
        q.add(new int[]{0, 0, 0, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int brokenWall = cur[2];
            int dist = cur[3];

            if (x == n - 1 && y == m - 1) {
                bw.write(String.valueOf(dist));
                bw.flush();
                bw.close();
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + DN[i];
                int nextY = y + DM[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (map[nextX][nextY] == 0 && !visited[nextX][nextY][brokenWall]) {
                        visited[nextX][nextY][brokenWall] = true;
                        q.add(new int[]{nextX, nextY, brokenWall, dist + 1});
                    } else if (map[nextX][nextY] == 1 && brokenWall < k && !visited[nextX][nextY][brokenWall + 1]) {
                        visited[nextX][nextY][brokenWall + 1] = true;
                        q.add(new int[]{nextX, nextY, brokenWall + 1, dist + 1});
                    }
                }
            }
        }

        bw.write("-1");
        bw.flush();
        bw.close();
    }
}