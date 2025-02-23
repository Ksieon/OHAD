import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Main{
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    static int BFS(int x, int y){
        //4. 시작 위치 0, 0 위치를 큐에 삽입
        queue.offer(new Point(x, y));
        //5. 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            //5-1. 큐에서 좌표 하나 꺼내오기
            Point currentPoint = queue.poll();
            int currentX = (int)(currentPoint.getX());
            int currentY = (int)(currentPoint.getY());
            for(int i=0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                //5-2. 인접한 위치에 길이 있다면(범위를 벗어나지 않고, 1이라면)
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && arr[nextX][nextY]==1){
                    queue.offer(new Point(nextX, nextY));
                    arr[nextX][nextY] = arr[currentX][currentY] + 1;
                }
            }
        }
        //6. arr[N-1][M-1] (0,0에서 시작했으므로) 값 반환
        return arr[N-1][M-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //1. N, M 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //2. N, M크기의 미로 배열에 값 입력 받기
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            //str.charAt(i)로 i인덱스 위치의 char 자료형 값 = 아스키 코드 값(0은 48, 1은 49) 불러오기 ( - '0의 아스키 코드 값(48)')
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        //3. BFS탐색 값 반환 받아 출력
        System.out.println(BFS(0, 0));
    }
}