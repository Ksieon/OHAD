import java.util.*;
import java.io.*;

public class myanswer2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Hashtable<Integer, Integer> hs = new Hashtable<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        st = new StringTokenizer(s1);
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            hs.put(i, a);
        }

        int M = Integer.parseInt(br.readLine());
        String s2 = br.readLine();
        st = new StringTokenizer(s2);
        for(int i=0; i<M; i++){
            Integer check = Integer.parseInt(st.nextToken());
            boolean flag = false;
            for(int j=0; j<N; j++){
                if(hs.get(j)==(Integer)(check)){
                    flag = true;
                    break;
                }
                else{
                    continue;
                }
            }
            if(flag==true){
                sb.append(1).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
