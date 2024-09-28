import java.util.*;
import java.io.*;

public class Main9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int numOfCard = Integer.parseInt(st.nextToken());
        int numOfAdd = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<numOfCard; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }
        for(int i=0; i<numOfAdd; i++){
            long sum = pq.poll()+pq.poll();
            pq.add(sum);
            pq.add(sum);
        }
        long result = 0;
         while(!pq.isEmpty()){
                result+=pq.poll();
        }
        System.out.println(result);
    }
}
