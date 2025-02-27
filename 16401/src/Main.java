import java.io.*;
import java.util.*;

public class Main {
    static int M, N, max=0;
    static int[] snacks;
    static boolean Check(int mid){
        //4. 과자들을 특정 값으로 나누어 나오는 총 과자의 수 구하기
        int numOfpiece = 0;
        for(int snack : snacks){
            numOfpiece += snack/mid;
        }
        //4. 총 과자의 수가 많다면 T(과자 길이 늘리기), 그렇지 않다면 F(과자 길이 줄이기)
        return numOfpiece>=M;
    }
    static int caculateMaxlength(){
        int lo = 0;
        int hi = max;
        while(lo+1<hi){
            int mid = (lo + hi)/2;
            //4. 조건 만족 여부에 따른 탐색 범위 재설정
            if(Check(mid)){
                lo = mid;
            } else {
                hi = mid;
            }
        }
        //5. 최종적으로 hi, lo중 만족하는 값을 반환
        return Check(hi) ? hi : lo;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //1. 조카의 수 M, 과자의 수 N
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        snacks = new int[N];
        //2. 과자들의 길이 저장(가장 긴 길이 max 체크)
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            snacks[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max, snacks[i]);
        }
        //3. 이분 탐색을 통한 최대 과자 길이 반환 받아 출력
        System.out.println(caculateMaxlength());
    }
}