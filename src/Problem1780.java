import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Problem1780 {
    static int count0 = 0;
    static int count1 = 0;
    static int count2 = 0;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(n, 0, 0);
        bw.write(count0 + "\n");
        bw.write(count1 + "\n");
        bw.write(count2 + "\n");
        bw.flush();
        bw.close();

    }

    public static void divide(int n, int x, int y) {
        if (checkPapaer(n, x, y)) {
            calculate(n, x, y);
        } else {
            int newN = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(newN, x + i * newN, y + j * newN);
                }
            }
        }
    }

    public static boolean checkPapaer(int n, int x, int y) {
        int first = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void calculate(int n, int x, int y) {
        if (arr[x][y] == 0) count1++;
        else if (arr[x][y] == 1) count2++;
        else count0++;
        return;
    }
}