import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        if(n == 1) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }

        dp[1] = 1;
        dp[2] = 2;


        for (int i = 3; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int result = dp[n] % 10007;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}