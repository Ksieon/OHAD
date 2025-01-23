import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max = Integer.MIN_VALUE;
    static int[] each_local_budget;

    static boolean Check(int _mid) {
        long cutting_result = 0;
        for (int i = 0; i < N; i++) {
            cutting_result += Math.min(each_local_budget[i], _mid);
        }
        return cutting_result <= M;
    }

    static int caculate_max_budget(int[] each_local_budget) {
        int lo = 0;
        int hi = max;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (Check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return Check(hi) ? hi : lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        each_local_budget = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            each_local_budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, each_local_budget[i]);
        }
        M = Integer.parseInt(br.readLine());

        System.out.println(caculate_max_budget(each_local_budget));
    }
}
