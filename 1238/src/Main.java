import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N; //num of student
    static int M; //num of road
    static int X; //promise place number
    static StringTokenizer st;
    static int dijkstra(int[][] _road){
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int first = X;
        distance[first] = 0;
        int vertex;
        for(int i=0; i<N-1; i++){
            vertex = findMinnum(_road, first);
            for(int w=0; w<N+1; w++){
                if(distance[w]==Integer.MAX_VALUE){
                    if(distance[vertex]>distance[first]+_road[first][vertex]){
                        distance[vertex] = distance[first] + _road[first][vertex];
                        first = vertex;
                    }
                }
            }
        }
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<N+1; i++){
            max_value = Math.max(max_value, distance[i]);
        }
        return max_value;
    }
    static int findMinnum(int[][] _road, int u){
        int min_value = Integer.MAX_VALUE;
        int vertex = 0;
        for(int i=0; i<N; i++){
            if(min_value>_road[u][i] && _road[u][i]!=0){
                vertex = i;
            }
        }
        return vertex;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int[][] road = new int[N+1][N+1];
        for(int i=0; i<N+1; i++){
            Arrays.fill(road[i], Integer.MAX_VALUE);
            road[i][i] = 0;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            road[x][y] = weight;
        }
        System.out.print(dijkstra(road));
    }
}
