import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11967 {
    static int[] DN = {1, -1, 0, 0};
    static int[] DM = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 1;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]>[][] q = new ArrayDeque[n+1][n+1];
        ArrayDeque<int[]> temp = new ArrayDeque<>();

        boolean[][] visited = new boolean[n+1][n+1];
        boolean[][] lightOn = new boolean[n+1][n+1];

        lightOn[1][1] = true;
        temp.push(new int[]{1, 1});

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                q[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            q[a][b].add(new int[]{c, d});
        }

        while (!temp.isEmpty()) {
            int[] cur = temp.poll();
            int x = cur[0];
            int y = cur[1];
            visited[x][y] = true;

            while (!q[x][y].isEmpty()) {
                int[] light = q[x][y].poll();
                int xLight = light[0];
                int yLight = light[1];

                if (!lightOn[xLight][yLight]) {
                    sum++;
                    lightOn[xLight][yLight] = true;
                    for (int i = 0 ; i < n+1; i++){
                        Arrays.fill(visited[i], false);
                    }
                }
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nextX = x + DN[i];
                int nextY = y + DM[i];

                if (nextX >= 0 && nextX <= n && nextY >= 0 && nextY <= n) {

                    if (!visited[nextX][nextY] && lightOn[nextX][nextY]) {
                        temp.push(new int[]{nextX, nextY});
                    }
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();

    }
}