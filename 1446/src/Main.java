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
        Arrays.sort(shortCut, 1, N+1, Comparator.comparingInt(a->a[0]));
        
        int[][] dp = new int[N+1][D+1];
        for(int k=0; k<=D; k++){
            dp[0][k] = k;
        }

        for(int i=1; i<=N; i++){
            int start = shortCut[i][0];
            int end = shortCut[i][1];
            for(int k=0; k<=D; k++){
                if(k>=end){
                    dp[i][k] = Math.min(dp[i-1][k], dp[i][start] + shortCut[i][2] + (k - end));
                } else {
                    dp [i][k] = Math.min(dp[i-1][k], k);
                }
            }
        }

        System.out.println(dp[N][D]);
    }
}