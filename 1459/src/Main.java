import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long case1 = (x+y)*w;

        long case2 = 0;
        if((x+y) %2==0){
            case2 = Math.max(x, y) * s;
        }
        else{
            case2 = (Math.max(x, y)- 1)*s + w;
        }
        long case3 = (Math.min(x, y))*s+(Math.abs(x-y))*w;

        System.out.println(Math.min(case1, Math.min(case2, case3)));
    }
}
