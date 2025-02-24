import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        
        int size = 1;
        while(size<K){
            size*=2;
        }
        int cut = 0;
        int purposePiece = size-K;
        int piece = size;
        while(purposePiece!=0){
            cut++;
            piece/=2;
            if(purposePiece>=piece){
                purposePiece-=piece;
            }
        }
        System.out.println(size + " " + cut);
    }
}