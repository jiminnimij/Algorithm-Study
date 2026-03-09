import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class  Problem2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            bw.write(arr[0] + "\n");
            bw.flush();
            bw.close();
            return;
        }

        else if (n == 2) {
            bw.write(arr[0] + arr[1] + "\n");
            bw.flush();
            bw.close();
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0], arr[1]) + arr[2];

        max = Math.max(dp[1], dp[2]);

        if (n == 3) {
            bw.write(max + "\n");
            bw.flush();
            bw.close();
            return;
        }

        dp[3] = Math.max(dp[1], dp[0] + arr[2]) + arr[3];
        if (dp[3] > max) {
            max = dp[3];
        }

        if (n < 4) {
            bw.write(max + "\n");
        }
        else {
            for (int i = 4; i < n; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]);
                dp[i] = Math.max(dp[i], dp[i - 4] + arr[i -1]) + arr[i];
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            bw.write(max + "\n");
        }

        bw.flush();
        bw.close();
    }
}