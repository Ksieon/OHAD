import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Integer score[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new Integer[N+1];
        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<score.length/2; i++){
            int temp = score[i];
            score[i] = score[score.length -1 -i];
            score[score.length -1 -i] = temp;
        }

        int result = 0;
        for(int i=0; i<=N; i++){
            result+=score[i];
            if((i+1)!=N && (i+2)!=N){
                if(score[i+1]<score[i+2]){
                    i++;
                }
                else{
                    continue;
                }
            }
            else{
                result+=((i+1)==N ? score[i+1] : ((i+2)==N) ? score[i+2] : 0);
            }
        }
        System.out.println(result);
    }
}
