import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int caculate(int N){
        //2. 5kg을 최대한 활용할 수 있는 최대값 greedy, 봉지의 개수를 셀 count
        int greedy = N/5;
        int count = 0;
        //2. 5kg 봉지(greedy)를 하나씩 줄여가며(0까지) 최대한 많이 활용하기
        for(int i=greedy; i>=0; i--){
            int weight = N;
            weight-=i*5;
            //3, 4. 5kg 봉지를 활용하고 남는 무게를 3kg 봉지로 들 수 있다면 count값 저장, 그렇지 않다면 반복
            if(weight%3==0){
                count = i + weight/3;
                break;
            }
        }
        //5. count값이 있다면 count 값 출력, 없다면(5kg, 3kg 봉지로 딱 나누어 떨어지지 않음) -1 출력
        return count!=0 ? count : -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 배달할 설탕 무게 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        System.out.println(caculate(N));
    }
}