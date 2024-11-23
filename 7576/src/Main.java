import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static int N;
    static int M;
    static int[][] box;
    static boolean[][] visited;
    static boolean None_zero;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 0};
    static int day_count = 0;
    
    static void BFS(int x, int y){
        None_zero = false;
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Point(x, y));
        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];
                if(nextX<0 || nextX >=N || nextY <0||nextY>=M){
                    continue;
                }
                if(visited[nextX][nextY]){
                    continue;
                }
                visited[nextX][nextY] = true;
                queue.offer(new Point(nextX, nextY));
                box[nextX][nextY] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j]==-1){
                    visited[i][j] = true;
                }
                if(box[i][j]==1&&!visited[i][j]){
                    BFS(i, j);
                }
            }
        }
    }
}
