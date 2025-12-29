import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem13549 {
    public static final int MAX = 100000;
    public static final int MIN = 0;
    public static boolean[] map = new boolean[MAX+1];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{n, 0});

        for (int i = 1; i < MAX+1; i++) {
            map[i] = false;
        }

        map[n] = true;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int num = temp[0];
            int count = temp[1];

            if (num == k) {
                bw.write(String.valueOf(count));
                bw.flush();
                bw.close();
                return;
            }
            if (num * 2 <= MAX && !map[num * 2]) {
                map[num * 2] = true;
                q.add(new int[]{num * 2, count});
            }
            if (num - 1 >= MIN && !map[num - 1]) {
                map[num - 1] = true;
                q.add(new int[]{num - 1, count + 1});
            }
            if (num + 1 <= MAX && !map[num + 1]) {
                map[num + 1] = true;
                q.add(new int[]{num + 1, count + 1});
            }

        }


    }
}