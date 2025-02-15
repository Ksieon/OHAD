import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //1. 동전의 종류 N, 만들 금액 K 입력 받음
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> coins = new Stack<>();
        //2,3. 각 종류의 동전을 입력 받음, 스택에 저장하여 높은 금액부터 그리디 알고리즘 적용
        for(int i=0; i<N; i++){
            coins.push(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        //4. 금액이 0원이 되면 알고리즘 종료 (A1 = 1이기 때문에 스택이 비었을 경우를 생각 안 해도 됨.)
        while(K!=0){
            int coin = coins.pop();
            //3-1,2. 금액으로 나눌 수 있다면 나눌 수 있는 만큼 나누고 몫을 저장. 그렇지 않다면 다음 동전으로로
            if((K/coin)>=1){
                result += K/coin;
                K%=coin;
            }
        }
        System.out.println(result);
    }
}
