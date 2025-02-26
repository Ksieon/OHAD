import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] stuff, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //물건 갯수 N, 배낭 무게 K
        st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //2. 물건들의 무게 W, 가치 V 를 변수 stuff[i][0], stuff[i][1]에 저장
        stuff = new int[N+1][2];
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }
        //3. 각 물건(i)을 하나씩 고려할 때, 해당 무게 값(j)에서 최대 가치 dp[i][j]
        dp = new int[N+1][K+1];
        //4. 각 물건의 무게  W, 가치 V를 고려, 이전 dp값 dp[i-1] 을 고려하여 dp[i][j]값 저장하기
        for(int i=1; i<=N; i++){
            int W = stuff[i][0];
            int V = stuff[i][1];
            for(int j=0; j<=K; j++){
                if(j>=W){
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i-1][j-W] + V);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //5. 모든 물건을 고려하여, 배낭에 최대 무게(K)로 물건을 담았을 때 배낭의 가치
        System.out.println(dp[N][K]);
    }
}