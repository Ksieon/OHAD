import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        int min_ch = 1;
        int count = 0;
        while(min_ch<K){
            min_ch*=2;
        }
        sb.append(min_ch).append(" ");
        while(K>0){
            if(K>=min_ch){
                K-=min_ch;
            }
            else{
                min_ch/=2;
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb.toString());
    }
}
