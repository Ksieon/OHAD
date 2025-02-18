import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 인사할 사람의 수 N 입력 받기
        int N = Integer.parseInt(br.readLine());
        //2. person 배열 (1번째부터 시작하기 위해서 N+1로 설정) 선언언 및 값 할당받기
        int[][] person = new int [N+1][2];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            person[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            person[i][1] = Integer.parseInt(st.nextToken());
        }
        //3. dp 배열 선언 
        int[][] dp = new int [N+1][100];
        //4. 조건에 따라서 dp배열에 값을 저장하고, 이를 활용하여 다음 dp값 구하기=>반복하여 최종 해에 도달달
        for(int i=1; i<=N; i++){
            int lose_health = person[i][0];
            for(int j=0; j<100; j++){
                if(lose_health<=j){
                    dp[i][j] = Integer.max(person[i][1]+dp[i-1][j-lose_health], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //5. 99의 체력(소진할 수 있는 체력 최대치)을 소진한 상태에서 얻을 수 있는 기쁨의 최대값 출력
        System.out.println(dp[N][99]);
    }
}