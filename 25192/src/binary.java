import java.io.*;
import java.util.*;

public class binary {
    static int val;

    static boolean Check(int mid) {
        return mid >= val;
    }

    static int findNumber(int val) {
        int lo = 0;
        int hi = 50;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (Check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return Check(hi) ? hi : lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        val = Integer.parseInt(br.readLine());
        System.out.println(findNumber(val));
    }
}
