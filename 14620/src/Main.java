import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;
    static int[][] A;
    static int N;
    static boolean[][] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N][N];
        V = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int depth, int sum){
        // 백트래킹 효율, 더이상 탐색할 필요가 없다면 연산을 종료한다.
        if(sum >= answer) return;

        if(depth == 3){
            answer = Math.min(sum, answer);
        }else{
            for(int i=1; i<N-1; i++){
                for(int j=1; j<N-1; j++){
                    if(!V[i][j] && checkVisit(i, j)){
                        int cost = sumCost(i, j);
                        DFS(depth+1, sum+cost);
                        clearVisit(i, j);
                    }
                }
            }
        }
    }

    static boolean checkVisit(int x, int y){
        for(int i=0; i<4; i++){
            if(V[x+dx[i]][y+dy[i]]){
                return false;
            }
        }
        return true;
    }
    static int sumCost(int x, int y){
        int sum = A[x][y];
        V[x][y] = true;
        for(int i=0; i<4; i++){
            sum += A[x+dx[i]][y+dy[i]];
            V[x+dx[i]][y+dy[i]] = true;
        }
        return sum;
    }
    static void clearVisit(int x, int y){
        for(int i=0; i<4; i++){
            V[x+dx[i]][y+dy[i]] = false;
        }
        V[x][y] = false;
    }
}