import java.io.*;
import java.util.*;

public class Problem16920 {
    static final int[] DN = {1, -1, 0, 0};
    static final int[] DM = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] speed = new int[p + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) speed[i] = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        ArrayDeque<int[]>[] q = new ArrayDeque[p + 1];
        for (int i = 1; i <= p; i++) q[i] = new ArrayDeque<>();

        int[] count = new int[p + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = map[i][j];
                if (c >= '1' && c <= '9') {
                    int player = c - '0';
                    q[player].add(new int[]{i, j});
                    count[player]++;
                }
            }
        }

        while (true) {
            boolean moved = false;

            for (int player = 1; player <= p; player++) {
                int s = speed[player];

                for (int step = 0; step < s; step++) {
                    int size = q[player].size();
                    if (size == 0) break;

                    for (int t = 0; t < size; t++) {
                        int[] cur = q[player].poll();
                        int x = cur[0], y = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + DN[d];
                            int ny = y + DM[d];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (map[nx][ny] != '.') continue;

                            map[nx][ny] = (char) ('0' + player);
                            count[player]++;
                            q[player].add(new int[]{nx, ny});
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            sb.append(count[i]).append(' ');
        }
        System.out.print(sb.toString());
    }
}
