import java.util.*;
import java.io.*;

public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                int A = Math.abs(a);
                int B = Math.abs(b);
                if(A>B){
                    return 1;
                }
                else if(A==B){
                    if(a>b){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
                else{
                    return -1;
                }
            }
        });

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num!=0){
                pq.add(num);
            }
            else{
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
