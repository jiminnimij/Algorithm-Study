import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Queue;
import java.util.LinkedList;

public class Problem1941 {
    static int count = 0;
    static final int n = 5;
    static final int max = 7;
    static int depth = 0;
    static int somCount = 0;
    static char[][] arr = new char[5][5];
    static boolean[][] visited = new boolean[n][n];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        backtracking(0);
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }

    static void backtracking(int start) throws IOException {
        if (depth == max) {
            if (somCount >= 4 && bfs()) {

                count++;
            }
            return;

        } else {
            for (int i = start; i < (n * n); i++) {
                int row = i % n;
                int col = i / n;
                if (max - depth < 4 - somCount) {
                    return;
                }

                if (!visited[col][row]) {
                    visited[col][row] = true;
                    if (arr[col][row] == 'S') {
                        somCount++;
                    }
                    depth++;

                    backtracking(i + 1);

                    visited[col][row] = false;
                    if (arr[col][row] == 'S') {
                        somCount--;
                    }
                    depth--;

                }
            }
        }

    }

    static boolean bfs() {
        int[] DX = {0, 0, -1, 1};
        int[] DY = {-1, 1, 0, 0};
        boolean[][] bfsVisited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    queue.offer(new int[]{j, i});
                    bfsVisited[i][j] = true;
                    break;
                }
            }
            if (!queue.isEmpty()) {
                break;
            }
        }


        int bfsCount = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            bfsVisited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = x + DX[i];
                int nextY = y + DY[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    if (visited[nextY][nextX] && !bfsVisited[nextY][nextX]) {
                        queue.offer(new int[]{nextX, nextY});
                        bfsVisited[nextY][nextX] = true;
                        bfsCount++;
                    }
                }
            }
        }

        return bfsCount == max;
    }

}