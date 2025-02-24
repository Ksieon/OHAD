import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int bitCount = Integer.toBinaryString(K).length();
        StringBuilder sb = new StringBuilder();
        if((K & (K - 1)) == 0) {
            sb.append(K).append(" ").append(0);
        } else {
            sb.append(1 << 2).append(" ").append(bitCount - Integer.numberOfTrailingZeros(K));
        }
        System.out.print(sb);
    }
}