import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Problem9328 {
    public static final int ALPHABET_SIZE = 26;
    public static int[] DN = {1, 0 , -1, 0};
    public static int[] DM = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] available = new boolean[ALPHABET_SIZE];
        ArrayDeque<int[]>[] doorQueues = new ArrayDeque[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            doorQueues[i] = new ArrayDeque<int[]>();
        }

        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int count = 0;
            char[][] map = new char[h][w];
            boolean[][] visited = new boolean[h][w];


            // 배열 채우기
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                map[i] = line.toCharArray();
            }

            // 초기 키 세팅
            String keys = br.readLine();
            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    available[keys.charAt(i) - 'a'] = true;
                }
            }

            // 초기 입장 값 세팅
            for (int i = 0; i < h; i++ ) {
                for (int j = 0; j < w; j++) {
                    char c = map[i][j];
                    if ((i == 0 || i == h - 1 || j == 0 || j == w - 1) && c != '*') {
                        if (c >= 'A' && c <= 'Z') {
                            if (available[c - 'A']) {
                                queue.add(new int[]{i, j});
                            } else {
                                doorQueues[c - 'A'].add(new int[]{i, j});
                                continue;
                            }
                        } else if (c >= 'a' && c <= 'z') {
                            available[c - 'a'] = true;
                            queue.add(new int[]{i, j});
                        } else if (c == '$') {
                            count++;
                            queue.add(new int[]{i, j});
                        }
                        else if (c == '.') {
                            queue.add(new int[]{i, j});
                        }
                        visited[i][j] = true;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int n = pos[0];
                int m = pos[1];

                for(int dir = 0 ; dir < 4; dir++) {
                    int nextN = n + DN[dir];
                    int nextM = m + DM[dir];
                    if(nextN < 0 || nextN >= h || nextM < 0 || nextM >= w) {
                        continue;
                    }
                    if(visited[nextN][nextM]) {
                        continue;
                    }
                    char c = map[nextN][nextM];
                    if(c == '*') {
                        continue;
                    }
                    else if(c == '$') {
                        count++;
                        visited[nextN][nextM] = true;
                        queue.add(new int[]{nextN, nextM});
                    }
                    else if(c >= 'A' && c <= 'Z') {
                        if(available[c - 'A']) {
                            visited[nextN][nextM] = true;
                            queue.add(new int[]{nextN, nextM});
                        }
                        else {
                            doorQueues[c - 'A'].add(new int[]{nextN, nextM});
                        }
                    }
                    else if(c >= 'a' && c <= 'z') {
                        int keyIndex = c - 'a';
                        if(!available[keyIndex]) {
                            available[keyIndex] = true;
                            while(!doorQueues[keyIndex].isEmpty()) {
                                int[] doorPos = doorQueues[keyIndex].poll();
                                for (int dir2 = 0; dir2 < 4; dir2++) {
                                    int nextN2 = doorPos[0] + DN[dir2];
                                    int nextM2 = doorPos[1] + DM[dir2];
                                    if (nextN2 < 0 || nextN2 >= h || nextM2 < 0 || nextM2 >= w) {
                                        continue;
                                    }
                                    if (visited[nextN2][nextM2]) {
                                        continue;
                                    }
                                    visited[doorPos[0]][doorPos[1]] = true;
                                    queue.add(new int[]{doorPos[0], doorPos[1]});
                                }
                            }
                        }
                        visited[nextN][nextM] = true;
                        queue.add(new int[]{nextN, nextM});
                    }
                    else {
                        visited[nextN][nextM] = true;
                        queue.add(new int[]{nextN, nextM});
                    }
                }
            }
            bw.write(count + "\n");

            Arrays.fill(available, false);
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                doorQueues[i].clear();
            }




        }

        bw.flush();
        bw.close();
    }
}