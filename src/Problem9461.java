import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Problem9461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long result = calculateTriangle(n);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static long calculateTriangle(int n) {
        long first = 1;
        long second = 1;
        long third = 1;

        if (n < 4) {
            return 1;
        }

        for (int i = 4; i < n + 1; i++) {
            long temp = first + second;
            first = second;
            second = third;
            third = temp;
        }

        return third;
    }

}