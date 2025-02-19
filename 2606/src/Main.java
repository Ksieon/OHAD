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
        //6-1. 시작 정점 1을 큐에 삽입 후 큐가 빌 때까지 반복
        queue.add(x);
        while(!queue.isEmpty()){
            int target = queue.poll();
            //6-2. 방문하지 않은 컴퓨터에 대해서 탐색 과정 수행
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
        //7. 방문한 컴퓨터 중 1번 컴퓨터를 제외한 연결된 컴퓨터의 수 출력
        return count-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 컴퓨터의 수, 연결된 간선의 수 압력 받기
        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        //2. List 크기 지정
        computers = new List[N+1];
        //3. List 내부 각 요소의 값을 ArrayList로 할당
        for(int i=1; i<=N; i++){
            computers[i] = new ArrayList<Integer>();
        }
        //4. 연결된 컴퓨터 정보 입력 받기
        StringTokenizer st;
        for(int i=0; i<C; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //4. 무방향 연결이므로 양쪽 헤드포인터에 각각 연결
            computers[a].add(b);
            computers[b].add(a);
        }
        //5. visited 배열 크기 지정
        visited = new boolean[N+1];
        System.out.println(BFS(1));
    }
}