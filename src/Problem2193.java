import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2193 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Long before1 = 1L;
        Long before2 = 1L;

        if (n == 1 || n == 2) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }

        for(int i = 3; i <= n ; i++) {
            Long temp = before2;
            before2 = before1;
            before1 = temp + before2;
        }

        bw.write(String.valueOf(before1));
        bw.flush();
        bw.close();


    }
}