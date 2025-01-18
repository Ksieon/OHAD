import java.util.*;
import java.io.*;
 
public class Main {// Boj_11066_파일 합치기
    static StringBuilder sb;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N + 1][N + 1];
            int[] sum = new int[N + 1];
 
            st = new StringTokenizer(br.readLine());
 
            for (int i = 1; i <= N; i++) {
                int value = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + value;
            }
            // 1부터 K의 부분합을 구해야한다.
            // 1,2+3 과 1, 2+3 중 최소값을 DP에 저장한다.
            // 수가 많아진다면?
            // 최종적으로 묶어지는 두개의 합을 구하는 과정이므로 한 묶음을 A와 B라면
            // mid로 범위를 나누어 누적합을 더해주면 된다.
            // 1부터 N 범위의 값을 다 더해준 값과 비교해야한다.
            for (int range = 1; range < N; range++) {
                for (int start = 1; start + range <= N; start++) {
                    int end = start + range;
                    dp[start][end] = Integer.MAX_VALUE;
 
                    for (int mid = start; mid < end; mid++) {
                        // dp[1][3] = Math.min(dp[1][2] + dp[3][3], dp[1][1] + dp[2][3])
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }
            System.out.println(dp[1][N]);
        }
    }
}