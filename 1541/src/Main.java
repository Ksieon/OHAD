import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringTokenizer st_plus;

        int total_sum = 0;
        boolean IsFirstToken = true;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            st_plus = new StringTokenizer(str, "+");
            int sum=0;
            while(st_plus.hasMoreTokens()){
                sum+=Integer.parseInt(st_plus.nextToken());
            }
            if(IsFirstToken){
                total_sum+=sum;
                IsFirstToken = false;
            }
            else{
                total_sum-=sum;
            }
        }
        System.out.println(total_sum);
    }
}
