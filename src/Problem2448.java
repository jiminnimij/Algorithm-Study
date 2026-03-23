import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Arrays;

public class Problem2448 {
    static char[][] arr;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int height = n;
        int width = (10 * n / 6) + (n / 3) - 1;
        arr = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(arr[i], ' ');
        }

        writeStar(height, width / 2, height - 1, width / 2);

        for (int i = 0 ; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void writeStar(int height, int width, int y, int x) {
        if (height == 3) {
            arr[y][x] = '*';
            arr[y][x - 1] = '*';
            arr[y][x + 1] = '*';
            arr[y][x - 2] = '*';
            arr[y][x + 2] = '*';
            arr[y - 1][x - 1] = '*';
            arr[y - 1][x + 1] = '*';
            arr[y - 2][x] = '*';
        }

        else {
            writeStar(height / 2, width / 2, y - height / 2  , x);
            writeStar(height / 2, width / 2, y, x - width / 2 - 1);
            writeStar(height / 2, width / 2, y, x + width / 2 + 1);
        }
    }
}
