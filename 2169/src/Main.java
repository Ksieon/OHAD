import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Point {
    private int x, y;
    public Point(int x, int y){
        x = this.x;
        y = this.y;
    }
}
public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0};
    static int[] dy = {0, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] value = new int[N+1][M+1];
        int[][] visited = new int [N+1][M+1];
        int[] dp = new int[N*M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        int x = 1, y=1;
        for(int k=1; k<=N*M; k++){
            
        }
    }
}
