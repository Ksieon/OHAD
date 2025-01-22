import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N, M, max;
    static int[] tree;
    static StringTokenizer st;

    static int Cutting(int[] trees) {
        int max_height = max;
        int min_height = 0;
        int middle_value = (max_height + min_height) / 2;
        int result_length = 0;
        while (min_height <= max_height) {
            for (int tree_length : trees) {
                if (tree_length - middle_value > 0)
                    result_length += tree_length - middle_value;
            }
            if (result_length < M) {
                max_height = middle_value - 1;
            } else {
                min_height = middle_value + 1;
            }
            middle_value = (max_height + min_height) / 2;
            result_length = 0;
        }
        return middle_value;
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