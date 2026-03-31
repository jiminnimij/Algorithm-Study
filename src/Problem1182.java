import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Problem1182 {
    static int count;
    static int n;
    static int s;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }

    static void backtracking(int i, int sum) {
        if (sum == s && i != 0) {
            count++;
        }

        for (int j = i; j < n; j++) {
            backtracking(j + 1, sum + arr[j]);
        }

    }



}