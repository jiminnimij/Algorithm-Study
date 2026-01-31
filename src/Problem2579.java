import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int stepCount = Integer.parseInt(br.readLine());

        int[] steps = new int[stepCount + 1];
        int[][] dp = new int[stepCount + 1][2];

        steps[0] = 0;

        for (int i = 1; i <= stepCount; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = steps[1];
        dp[1][1] = steps[1];

        for(int i = 2; i <= stepCount; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + steps[i];
            dp[i][1] = dp[i-1][0] + steps[i];
        }

        bw.write(String.valueOf(Math.max(dp[stepCount][0], dp[stepCount][1])));
        bw.flush();
        bw.close();
    }

}