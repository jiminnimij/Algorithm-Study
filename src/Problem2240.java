import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int max = 0;

        int[][][] dp = new int [w + 1][t + 1][2];
        int[] arr = new int[t + 1];
        arr[0] = 1;
        dp[0][0][0] = 0;

        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[0][i][0] = 0;
            dp[0][i][1] = 0;
        }

        for (int i = 1; i < t + 1; i++) {
            dp[0][i][0] = dp[0][i - 1][0] + (arr[i] == 1 ? 1 : 0);

            for(int j = 1; j < Math.min(i + 1, w + 1) ; j++ ) {
                for(int k = 0; k < 2; k++) {
                    dp[j][i][k] = Math.max(dp[j][i - 1][k], dp[j - 1][i - 1][1 - k]) + (k + 1 == arr[i] ? 1 : 0);

                    if (max < dp[j][i][k]) {
                        max = dp[j][i][k];
                    }
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}