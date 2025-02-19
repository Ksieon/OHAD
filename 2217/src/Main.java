import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 로프의 수 N 입력 받기
        int N = Integer.parseInt(br.readLine());
        //2. 반복문을 통해서 rope 배열에 삽입
        Integer[] rope = new Integer[N];
        for(int i=0; i<N; i++){
            rope[i] =Integer.parseInt(br.readLine());
        }
        //3. Collections 클래스의 reverseOrder 메소드를 사용하여 중량을 내림차순 정렬
        Arrays.sort(rope, Collections.reverseOrder());
        //4. 사용하는 로프의 수를 나타낼 count변수, 최대값 max 변수 정의
        int count = 1;
        int max = 0;
        //5. 중량이 높은 순서대로 count값과 곱하고, 이 값을 max값과 비교, 저장
        for(int i=0; i<N; i++){
            max = Integer.max(rope[i]*count, max);
            count++;
        }
        //6. max값 출력
        System.out.println(max);
    }
}
