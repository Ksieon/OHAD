import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        int size = 1;
        int multiplier = 0;
        while(size<K){
            size*=2;
            multiplier++;
        }
        sb.append(size).append(" ");
        int cut = 0;
        if(K%2!=0){
            cut+=multiplier;
        } else {
            int purposePiece = size - K;
            while(size!=purposePiece && purposePiece!=0){
                size/=2;
                cut++;
            }
        }
        sb.append(cut);
        System.out.println(sb.toString());
    }
}
