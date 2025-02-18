import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //1. 남은 기간 N, 총 챕터 수 M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //2. i번째 챕터를 읽는 데에 걸리는 일 수(book[i][0]), 
        // i번째 챕터를 읽으면 읽게되는 페이지 수(book[i][1])를 저장할 배열
        int[][] book = new int[M+1][2];
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            book[i][0] = Integer.parseInt(st.nextToken());
            book[i][1] = Integer.parseInt(st.nextToken());
        }
        //3. i번째 챕터를 j일 수마늠 활용했을 때, 읽게되는 페이지 수를 dp[i][j]에 저장
        int[][] dp = new int[M+1][N+1];
        //4. 조건에 따라서 동적으로 dp값을 저장하고, 이를 활용하여 다음 dp값 구하기
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(j-book[i][0]>=0){
                    dp[i][j] = Integer.max(book[i][1]+dp[i-1][j-book[i][0]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //5. 마지막 챕터 M번째까지 고려해서 남은 기간 N일을 최대로 활용했을 때 읽을 수 있는 페이지 수 출력
        System.out.println(dp[M][N]);
    }
}