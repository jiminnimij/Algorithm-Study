import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2447 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        writeStars(n, 0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(map[i][j]);
            }
            if (i != n -1 ) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void writeStars(int n, int r, int c) {
        if(n == 3) {
            map[r][c] = '*';
            map[r][c + 1] = '*';
            map[r][c + 2] = '*';
            map[r + 1][c] = '*';
            map[r + 1][c + 1] = ' ';
            map[r + 1][c + 2] = '*';
            map[r + 2][c] = '*';
            map[r + 2][c + 1] = '*';
            map[r + 2][c + 2] = '*';
        } else {
            int size = n / 3;
            writeStars(size, r, c);
            writeStars(size, r, c + size);
            writeStars(size, r, c + size * 2);
            writeStars(size, r + size, c);
            writeSpace(size, r + size, c + size);
            writeStars(size, r + size, c + size * 2);
            writeStars(size, r + size * 2, c);
            writeStars(size, r + size * 2, c + size);
            writeStars(size, r + size * 2, c + size * 2);
        }
    }

    public static void writeSpace(int n, int r, int c) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                map[i][j] = ' ';
            }
        }
    }
}