import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //1. 정수 A, B 값
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        //2. 연산 횟수 count
        int count = 0;
        //3. B>A라면 세 조건 반복
        while(B>A){
            //3-1. B가 홀수인데 끝자리가 1이 아닐 때
            if(B%10!=1 && B%2!=0){
                break;
            }
            //3-2. B의 끝자리가 1일 때
            if(B%10==1){
                B/=10;
            }
            //3-3. B가 짝수일 때
            else {
                B/=2;
            }
            count++;
        }
        //4. B가 A와 같아졌는지 여부에 따라 result값 출력
        int result = B==A ? count + 1 : -1;
        System.out.println(result);
    }
}