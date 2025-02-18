import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static boolean [] visited;
    static List<Integer>[] computers;
    static int BFS(int x){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.add(x);
        while(!queue.isEmpty()){
            int target = queue.poll();
            if(!visited[target]){
                visited[target] = true;
                count++;
                for(int i=0; i<computers[target].size(); i++){
                    int next_target = (int)(computers[target].get(i));
                    if(visited[next_target]!=true){
                        queue.add(next_target);
                    }
                }
            }
        }
        return count-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        computers = new List[N+1];

        for(int i=1; i<=N; i++){
            computers[i] = new ArrayList<Integer>();
        }
        
        StringTokenizer st;
        for(int i=0; i<C; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }

        visited = new boolean[N+1];

        System.out.println(BFS(1));
    }
}
