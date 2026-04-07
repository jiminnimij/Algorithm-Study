import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Problem15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int[] arr;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int max = 0;

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        count = new int[max + 1];
        visited = new boolean[max + 1];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        arr = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(arr);

        backtracking(0, 0, "");

        bw.flush();
        bw.close();
    }

    static void backtracking(int depth, int start, String str) throws IOException {
        if (depth == m) {
            bw.write(str);
            bw.newLine();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (count[arr[i]] > 0){
                    count[arr[i]]--;
                    backtracking(depth + 1, i + 1, str + arr[i] + " ");
                    count[arr[i]]++;
                }

            }
        }
    }
}