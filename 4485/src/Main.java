import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] cave;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int count = 1;
    static int dijkstra(int[][] _cave){
        int[][] distance = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)-> o1[2]-o2[2]);
        pq.offer(new int[]{0, 0, cave[0][0]});
        distance[0][0] = cave[0][0];
        while(!pq.isEmpty()){
            int tmp[] = pq.poll();
            int x = tmp[0];
            int y = tmp[1];
            int weight = tmp[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    if(distance[nx][ny]>distance[x][y]+cave[nx][ny]){
                        distance[nx][ny] = distance[x][y] + cave[nx][ny];
                        pq.offer(new int[]{nx, ny, distance[nx][ny]});
                    }
                }
            }
        }
        return distance[N-1][N-1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            cave = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem "+ count++ + ":" + dijkstra(cave) +"\n");
        }
        System.out.print(sb.toString());
    }
}