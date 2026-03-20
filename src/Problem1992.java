import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Queue;
import java.util.LinkedList;

public class Problem1992 {
    static char[][] map;

    static Queue<Character> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        divide(n, 0, 0);

        while (!queue.isEmpty()) {
            bw.write(queue.poll());
        }
        bw.flush();
        bw.close();
    }

    public static void divide(int n, int r, int c) {
        if (check(n, r, c)) {
            queue.add(map[r][c]);
            return;
        }
        else {
            queue.add('(');
            divide(n / 2, r, c);
            divide(n / 2, r, c + n / 2);
            divide(n / 2, r + n / 2, c);
            divide(n / 2, r + n / 2, c + n / 2);
            queue.add(')');
        }

    }

    public static boolean check(int n, int r, int c) {
        char first = map[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (map[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}