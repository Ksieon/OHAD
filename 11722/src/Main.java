import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int arr[]=new int[1001];
    static int result_count = -1;
    static int decrease_count(int[] arr){
        for(int i=0; i<N; i++){
            int count = 1;
            int compare_num = arr[i];
            for(int j=i; j<N-1; j++){
                if(arr[i]>arr[j+1]){
                    if(compare_num>arr[j+1]){
                        count++;
                        compare_num = arr[j+1];
                    }
                    else if(compare_num==arr[j+1]){
                        continue;
                    }
                    else{
                        compare_num = arr[j+1];
                        continue;
                    }
                }
                else{
                    continue;
                }
            }
            result_count = Math.max(count, result_count);
        }
        return result_count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(decrease_count(arr));
    }
}
