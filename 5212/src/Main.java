import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] graph; // 지도
    static int count; // 섬 근처의 바다의 수
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        int up = R; // 지도의 가장 위
        int down = 0; // 지도의 가장 아래
        int left = C; // 지도의 가장 왼쪽
        int right = 0; // 지도의 가장 아래쪽

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'X') {
                    count = 0;
                    for (int k = 0; k < 4; k++) { // 우 좌 하 상 순서 4방 탐색
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C) { // 지도 안에 있을경우
                            if (graph[nx][ny] == '.') { // 근처가 바다일 경우
                                count++;
                            }
                        } else { // 지도의 바깥부분도 바다
                            count++;
                        }
                    }
                    if (count >= 3) { // 바다가 3면 이상일 경우
                        graph[i][j] = 'S'; // 임의의 값 S 로 변경
                    }
                }
                if (graph[i][j] == 'X') { // 지도의 가장 위, 아래, 왼쪽, 오른쪽 의 좌표를 갱신
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        // 새로운 지도를 그려줌
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                char c = graph[i][j];
                if (c == 'X') {
                    bw.write(c);
                } else {
                    bw.write('.');
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}