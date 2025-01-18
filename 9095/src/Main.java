import java.util.*;
import java.io.*;


public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];
            dp[1] = 1; // 1 = 1;
            dp[2] = 2; // 1+1, 2 = 2;
            dp[3] = 4; // 1+1+1, 1+2, 2+1, 3 = 4;
            //dp[4] = 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1 = 1+2+4 = 7;
            //dp[5] = 2+4+7 = 13;
            //dp[6] = 4+7+13 = 25;
            for(int j=4; j<=n; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            sb.append(dp[n]+"\n");
        }
        System.out.print(sb.toString());
    }
}
