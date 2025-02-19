import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            arr.add(br.readLine());
        }
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                String s1 = arr.get(i);
                String s2 = arr.get(j);
                if(s1.length()>s2.length()){
                    arr.add(i, s2);
                    arr.add(j, s1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(arr.get(i)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
