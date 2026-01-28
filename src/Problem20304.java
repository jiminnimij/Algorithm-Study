import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem20304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int size = 32 - Integer.numberOfLeadingZeros(n);

        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < m; i++) {
            int node = Integer.parseInt(st.nextToken());
            q.add(node);
            dist[node] = 0;
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0 ; i < size; i++) {
                int num = cur ^ (1 << i);

                if (num <= n && dist[num] == -1) {
                    dist[num] = dist[cur] + 1;
                    q.add(num);
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i <= n; i++) {
            if (dist[i] > max) {
                max = dist[i];
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
}