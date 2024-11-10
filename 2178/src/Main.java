import java.util.*;
import java.io.*;
import java.awt.*; // ★

class Main{
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // ★
    static int[] dy = {0, 0, -1, 1};
    static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                if(nextX <0 || nextX >= N || nextY<0 || nextY >= M){
                    continue;
                }
                if(arr[nextX][nextY]==0){
                    continue;
                }
                if(visited[nextX][nextY]){
                    continue;
                }
                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY]= true;
                arr[nextX][nextY] = arr[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        String row;
        for(int i=0; i<N; i++){
            row = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(row.charAt(j))); // ★
            }
        }
        BFS(0, 0);
        System.out.println(arr[N-1][M-1]);
    }
}
