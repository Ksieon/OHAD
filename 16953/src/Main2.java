import java.io.*;
import java.util.*;

public class Main2 {
    static long A, B;
    static int min = Integer.MAX_VALUE;
    static void BFS(long A, long B, int count){
        if(A>=B){
            min = A==B ? Math.min(min, count+1) : min;
            return;
        }
        BFS(A*2, B, count+1);
        BFS(A*10 + 1, B, count+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        BFS(A, B, 0);
        int result = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(result);
    }
}