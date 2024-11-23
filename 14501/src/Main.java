import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] T, P;
    static int answer = 0;

    static void DFS(int day, int money) {
        // 종료 조건
        if (day > N) {
            answer = Math.max(answer, money);
            return;
        }

        // 현재 일을 선택하지 않는 경우
        DFS(day + 1, money);

        // 현재 일을 선택하는 경우 (날짜를 초과하지 않는지 확인)
        if (day + T[day] <= N + 1) {
            DFS(day + T[day], money + P[day]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, 0);
        System.out.println(answer);
    }
}
