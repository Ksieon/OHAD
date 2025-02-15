import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1. N을 입력받고, 각 줄에 숫자를 하나씩 입력 받아 배열에 넣음
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for(int i=0; i<N; i++){
			nums[i] = Integer.parseInt(br.readLine());
		}
		//2. 스택, 출력값을 저장할 StringBuilder
		//2. 수열 생성 가능 여부 boolean, 1부터 오름차순으로 stack에 넣을 변수 k
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean isPossible = true;
		int k=1;
		//2. 반복문을 통해서 배열 속 숫자를 하나씩 불러옴
		for(int i=0; i<N; i++){
			int num = nums[i];
			//3. k를 배열 숫자값까지 오름차순으로 stack에 push (+ 저장)
			for( ; k<=num; k++){
				stack.push(k);
				sb.append('+').append('\n');
			}
			//4. 만약 배열 숫자값이 peek와 일치시 pop, (-저장) 5. 그렇지 않다면 boolean값 false
			if(num==stack.peek()){
				stack.pop();
				sb.append('-').append('\n');
			} else {
				isPossible = false;
			}
		}
		//6. boolean 값에 따라 출력
		if(isPossible){
			System.out.print(sb.toString());
		} else {
			System.out.println("NO");
		}
}
}