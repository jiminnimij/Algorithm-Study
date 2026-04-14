import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Problem16987 {
    static int n;
    static int max = 0;
    static int count = 0;
    static int[][] eggs;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }

    static void backtracking(int index) throws IOException {
        boolean flag = false;
        if (index == n) {
            if (count > max) {
                max = count;
            }
            return;
        }
        else {
            for (int i = 0; i < n; i++) {
                if (i == index) {
                    if (i == n - 1) {
                        backtracking(index + 1);
                    }
                    continue;
                }

                if (eggs[index][0] < 1) {
                    backtracking(index + 1);
                    continue;
                }
                if (eggs[i][0] > 0) {
                    eggs[index][0] -= eggs[i][1];
                    eggs[i][0] -= eggs[index][1];
                    flag = true;


                    if (eggs[index][0] < 1 && eggs[i][0] < 1) {
                        count += 2;

                        backtracking(index + 1);

                        count -= 2;
                    }
                    else if (eggs[index][0] < 1) {
                        count += 1;

                        backtracking(index + 1);

                        count -= 1;
                    }
                    else if (eggs[i][0] < 1) {
                        count += 1;

                        backtracking(index + 1);

                        count -= 1;
                    }

                    else {
                        backtracking(index + 1);
                    }

                    eggs[index][0] += eggs[i][1];
                    eggs[i][0] += eggs[index][1];
                }

            }
            if (!flag) {
                backtracking(index + 1);
            }
        }
    }
}