import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem2748 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long dp1 = 0;
        long dp2 = 1;

        if (n  == 0) {
            bw.write(String.valueOf(dp1));
        }
        else if (n == 1) {
            bw.write(String.valueOf(dp2));
        }
        else {
            for (int i = 2; i <= n; i++) {
                long temp = dp2;
                dp2 = dp1 + dp2;
                dp1 = temp;
            }
            bw.write(String.valueOf(dp2));
        }

        bw.flush();
        bw.close();
    }
}