import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int max = Integer.MIN_VALUE;
    static int lancable[];

    static boolean Check(int mid) {
        long result_cable_num = 0;
        for (int cable : lancable) {
            result_cable_num += cable / mid;
        }
        return result_cable_num >= N;
    }

    static long cut_cable(int[] lancable) {
        int lo = 1;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lancable = new int[K];
        for (int i = 0; i < K; i++) {
            lancable[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lancable[i]);
        }
        System.out.println(cut_cable(lancable));
    }
}
