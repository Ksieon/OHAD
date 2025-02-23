import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, day = Integer.MIN_VALUE;
    static int[][] tomatoBox;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> queue = new LinkedList<>();
    static void BFS(){
        //4. 큐가 비어있을 때 까지
        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            int currentX = (int)(currentPoint.getX());
            int currentY = (int)(currentPoint.getY());
            //4-1. 익은 토마토(기준)의 상하좌우 위치 탐색
            for(int i=0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                //4-1. 만약 조건에 부합하면 큐에 삽입, 해당 토마토 위치에 (기준값 + 1) 부여
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && tomatoBox[nextX][nextY]==0){
                    queue.offer(new Point(nextX, nextY));
                    tomatoBox[nextX][nextY] = tomatoBox[currentX][currentY] + 1;
                }
            }
        }
    }
    static int caculateDays(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                //5-1. 익지 않은 토마토 발견시 즉시 -1 출력
                if(tomatoBox[i][j]==0){
                    return -1;
                }
                //5-2. 박스 내부에서 마지막으로 익은 토마토의 값을 day 변수에 저장
                day = Math.max(tomatoBox[i][j], day);
            }
        }
        //5-2. 익는 데에 걸리는 일수이므로 day-1 반환
        return day-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //1. M(열) N(행) 입력 받고 박스 크기 할당
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoBox = new int[N][M];
        //2. 토마토 박스 정보 저장
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //3. 익은 토마토들의 좌표 값을 모두 큐에 삽입
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tomatoBox[i][j]==1){
                    queue.offer(new Point(i, j));
                }
            }
        }
        //4. BFS 탐색 시작, 토마토 위치에 값 부여
        BFS();
        //5. 모두 익는 최소 일수 구하여 출력
        System.out.println(caculateDays());
    }
}