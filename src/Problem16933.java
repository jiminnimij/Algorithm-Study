import java.io.*;
import java.util.*;

public class Problem16933 {
    static int N, M, K;
    static char[][] grid;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static class State {
        int x, y, broken, day;
        State(int x, int y, int broken, int day) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.day = day;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        for (int i = 0; i < N; i++) grid[i] = br.readLine().toCharArray();

        int[][][][] dist = new int[N][M][K + 1][2];
        ArrayDeque<State> q = new ArrayDeque<>();

        dist[0][0][0][0] = 1;
        q.add(new State(0, 0, 0, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            int d = dist[cur.x][cur.y][cur.broken][cur.day];

            if (cur.x == N - 1 && cur.y == M - 1) {
                bw.write(String.valueOf(d));
                bw.newLine();
                bw.flush();
                return;
            }

            int nd = 1 - cur.day;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (grid[nx][ny] == '0') {
                    if (dist[nx][ny][cur.broken][nd] == 0) {
                        dist[nx][ny][cur.broken][nd] = d + 1;
                        q.add(new State(nx, ny, cur.broken, nd));
                    }
                } else {
                    if (cur.day == 0 && cur.broken < K) {
                        int nb = cur.broken + 1;
                        if (dist[nx][ny][nb][nd] == 0) {
                            dist[nx][ny][nb][nd] = d + 1;
                            q.add(new State(nx, ny, nb, nd));
                        }
                    }
                }
            }

            if (dist[cur.x][cur.y][cur.broken][nd] == 0) {
                dist[cur.x][cur.y][cur.broken][nd] = d + 1;
                q.add(new State(cur.x, cur.y, cur.broken, nd));
            }
        }

        bw.write("-1");
        bw.newLine();
        bw.flush();
    }
}
