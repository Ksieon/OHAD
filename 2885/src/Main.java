import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. K값 입력 받기
        int K = Integer.parseInt(br.readLine());
        //2. size값 구하기
        int size = 1;
        while(size<K) size *=2;
        //3, 쪼개는 횟수 cut, 쪼개진 조각 piece
        int cut = 0;
        int piece = size;
        //4. K가 0이 될 때까지 piece를 쪼개어 빼준다.
        while(K>0){
            if(K>=piece){
                K-=piece;
            } else {
                piece/=2;
                cut++;
            }
        }
        //5. size, cut 출력
        System.out.println(size + " " + cut);
    }
}