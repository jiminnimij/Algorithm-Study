import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem2573 {
    static int[] DN = {1, -1, 0, 0};
    static int[] DM = {0, 0, 1, -1};
    static Queue<int[]> melt = new LinkedList<>();
    static Queue<int[]> count = new LinkedList<>();

    static int sum = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] iceburg = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                iceburg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            // 덩어리 개수 세기
            int iceburgCount = countIceburg(iceburg, n, m);

            if (iceburgCount > 1) {
                break;
            }

            if (melt.isEmpty()) {
                time = 0;
                break;
            }

            // 멜팅 로직
            meltIceburg(iceburg, n, m);
            time++;


        }
        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }

    public static int countIceburg(int[][] iceburg, int n, int m) {
        sum = 0;

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (iceburg[i][j] > 0 && !visited[i][j]) {
                    sum++;
                    visited[i][j] = true;

                    count.add(new int[]{i, j});

                    while (!count.isEmpty()) {
                        int[] cur = count.poll();
                        int x = cur[0];
                        int y = cur[1];
                        int meltCount = 0;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + DN[k];
                            int ny = y + DM[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (iceburg[nx][ny] == 0) {
                                    meltCount++;
                                }
                                if (iceburg[nx][ny] > 0 && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    count.add(new int[]{nx, ny});
                                }
                            }
                        }
                        melt.add(new int[]{x, y, meltCount, time});
                    }
                }
            }
        }

        return sum;
    }

    public static void meltIceburg(int[][] iceburg, int n, int m) {
        while (!melt.isEmpty()) {
            int[] cur = melt.peek();
            if (cur[3] == time) {
                melt.poll();
                int x = cur[0];
                int y = cur[1];
                int meltCount = cur[2];

                iceburg[x][y] -= meltCount;
                if (iceburg[x][y] < 0) {
                    iceburg[x][y] = 0;
                }
            }
            else {
                break;
            }
        }
    }
}