import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1074 {
    static int count = -1;
    static boolean flag = false;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        findZ(size, r, c, size - 1, size - 1);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static void findZ(int n, int r, int c, int row, int col) {
        if (flag) {
            return;
        }
        if (n == 2) {
            count += compare(r, c, row, col);
        }
        else {
            if (r <= row - n / 2 && c <= col - n / 2) {
                findZ(n / 2, r, c, row - n / 2, col - n / 2);
            }
            else if (r <= row - n /2) {
                count += (n / 2) * (n / 2);
                findZ(n / 2, r, c, row - n / 2, col);
            }
            else if (c <= col - n / 2) {
                count += (n / 2) * (n / 2) * 2;
                findZ(n / 2, r, c, row, col - n / 2);
            }
            else {
                count += (n / 2) * (n / 2) * 3;
                findZ(n / 2, r, c, row, col);
            }
        }
    }
    public static int compare(int r, int c, int row, int col) {
        if (r == row - 1 && c == col - 1) {
            flag = true;
            return 1;
        } else if (r == row - 1 && c == col) {
            flag = true;
            return 2;
        } else if (r == row && c == col - 1) {
            flag = true;
            return 3;
        } else if (r == row && c == col) {
            flag = true;
            return 4;
        }
        else {
            return 4;
        }
    }
}