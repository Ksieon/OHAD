import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max = Integer.MIN_VALUE;
    static int[] tree;
    static StringTokenizer st;

    static boolean Check(int _mid) {
        long result_length = 0;
        for (int tree_length : tree) {
            if (tree_length - _mid > 0)
                result_length += tree_length - _mid;
        }
        return result_length>=M;
    }

    static int Cutting(int[] tree) {
        int hi = max;
        int lo = 0;
        while (lo + 1 < hi) { // [lo, hi]
            int mid = (hi + lo) / 2;
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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
        System.out.println(Cutting(tree));
    }
}