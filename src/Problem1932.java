import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int [n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 0; j <= i; j++) {

                if (i == 0) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
                else if (i == 1) {
                    dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i-1][0];
                }
                else if (j == 0) {
                    dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i-1][j];
                }
                else if (j == i) {
                    dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Integer.parseInt(st.nextToken()) + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }

            }
        }

        int max = 0;
        for (int j = 0; j < n; j++) {
            if (dp[n-1][j] > max) {
                max = dp[n-1][j];
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
}