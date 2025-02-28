import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] nums, dp;
    static int calculateMaxScore(){
        for(int i=1; i<=N; i++){
            dp[i][0] = Integer.max(dp[i-1][0] + nums[i][0], dp[i-1][1] + nums[i][0]);
            dp[i][1] = Integer.max(dp[i-1][1] + nums[i][1], Integer.max(dp[i-1][0] + nums[i][1], dp[i-1][2] + nums[i][1]));
            dp[i][2] = Integer.max(dp[i-1][2] + nums[i][2], dp[i-1][1] + nums[i][2]);
        }
        int max = -1;
        for(int numOflastline : dp[N]){
            max = Integer.max(max, numOflastline);
        }
        return max;
    }
    static int calculateMinScore(){
        for(int i=1; i<=N; i++){
            dp[i][0] = Integer.min(dp[i-1][0] + nums[i][0], dp[i-1][1] + nums[i][0]);
            dp[i][1] = Integer.min(dp[i-1][1] + nums[i][1], Integer.min(dp[i-1][0] + nums[i][1], dp[i-1][2] + nums[i][1]));
            dp[i][2] = Integer.min(dp[i-1][2] + nums[i][2], dp[i-1][1] + nums[i][2]);
        }
        // 숫자의 최대값은 9이고, N<=100,000이므로 최대 값 900,000
        int min = 900001;
        for(int numOflastline : dp[N]){
            min = Integer.min(min, numOflastline);
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 숫자표 행의 개수 N
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1][3];
        StringTokenizer st;
        //2. nums 배열의 0, 1, 2번 위치에 숫자 입력 받기 (숫자표)
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
        }
        //3. dp배열에 현재 위치에서 최대(최소) 값을 저장하며 최종적인 해 도출
        dp = new int[N+1][3];
        System.out.println(calculateMaxScore() + " " + calculateMinScore());
    }
}