import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Problem17071 {
    public static final int MAX_VALUE = 500001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 수빈 위치
        int n = Integer.parseInt(st.nextToken()); // 동생 위치
        int time = 0;
        int size = 0;
        boolean[][] map = new boolean[2][MAX_VALUE];

        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(m); // 수빈 위치, time, sum할 값
        map[0%2][m] = true;

        while (!q.isEmpty()) {
            size = q.size();
            n = n + time;

            if(n > MAX_VALUE-1) {
                break;
            }

            for (int i = 0; i < size; i++) {
                int current = q.poll();
                int nextTime = (time + 1) % 2;

                if(map[time % 2][n]) {
                    bw.write(String.valueOf(time));
                    bw.flush();
                    bw.close();
                    return;
                }

                if(current * 2 < MAX_VALUE) {
                    if (!map[nextTime][current * 2]) {
                        map[nextTime][current * 2] = true;
                        q.add(current*2);
                    }
                }

                if(current + 1 < MAX_VALUE) {
                    if (!map[nextTime][current + 1]) {
                        map[nextTime][current + 1] = true;
                        q.add(current + 1);
                    }
                }

                if(current - 1 >= 0) {
                    if (!map[nextTime][current - 1]) {
                        map[nextTime][current - 1] = true;
                        q.add(current - 1);
                    }
                }
            }
            time++;

        }

        bw.write("-1");
        bw.flush();
        bw.close();
    }
}