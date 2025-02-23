import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int size = 1;
        int multiplier = 0;
        while(size<K){
            size*=2;
            multiplier++;
        }
        //256 128 64 32 16 8 4(44-32)
        int cut = 0;
        if(K%2!=0){
            cut+=multiplier;
        } else {
            if(size-K!=0){
                int purposePiece = size-K;
                int piece = size;
                while(purposePiece!=0){
                    cut++;
                    piece/=2;
                    if(purposePiece>=piece){
                        purposePiece-=piece;
                    }
                }
            }
        }
        System.out.println(size + " " + cut);
    }
}