import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        //1. 지름길의 개수 N, 고속도로의 길이 D
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        //2. 지름길을 저장할 배열 (idx 0: 지름길 시작 위치, idx 1: 지름길 끝 위치, idx 2: 지름길 거리)
        int[][] shortCut = new int[N+1][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            shortCut[i][0] = Integer.parseInt(st.nextToken());
            shortCut[i][1] = Integer.parseInt(st.nextToken());
            shortCut[i][2] = Integer.parseInt(st.nextToken());
        }
        //3. 지름길을 시작 위치를 기준으로 오름차순 정렬 (1~N+1 인덱스까지 0번 인덱스를 기준으로 오름차순)
        Arrays.sort(shortCut, 1, N+1, Comparator.comparingInt(a->a[0]));
        //4. 각 지름길에 대한, 해당 위치값 k에서의 총 이동 거리값 저장 배열 dp
        int[][] dp = new int[N+1][D+1];
        //4. dp[0]은 아무 지름길도 고려하지 않았을 때 k위치에서 총 이동 거리값(k)
        for(int k=0; k<=D; k++){
            dp[0][k] = k;
        }
        //5. 각 지름길을 순차적으로 고려하며, 위치값 k에서의 총 이동거리 값 저장
        for(int i=1; i<=N; i++){
            int start = shortCut[i][0];
            int end = shortCut[i][1];
            for(int k=0; k<=D; k++){
                //5-1 지름길을 이용한 거리(k>=지름길 끝 위치)까지 왔을 때, 이전 dp값과 현재 지름길을 이용했을 때의 거리를 비교하여 최소값을 저장
                if(k>=end){
                    dp[i][k] = Math.min(dp[i-1][k], dp[i][start] + shortCut[i][2] + (k - end));
                } else {
                    dp [i][k] = Math.min(dp[i-1][k], k);
                }
            }
        }
        //6. 모든 지름길을 고려했을 때, 위치 값 D에서의 최소 이동 거리
        System.out.println(dp[N][D]);
    }
}