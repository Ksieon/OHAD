import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] nums = new int[5][2];
        for (int i = 0; i < 5; i++) {
            nums[i][0] = Integer.parseInt(br.readLine());
        }

        int count_1 = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i][1] != 1) {
                int num = nums[i][0]; // 숫자 하나에 대한 탐색 시작
                count_1++;
                for (int j = 0; j < 5; j++) {
                    if (j == i) { // 자신의 인덱스는 건너뜀
                        continue;
                    } else { // 자신의 인덱스가 아닐 시
                        if (num == nums[j][0]) {
                            nums[j][1] = 1;
                        }
                    }
                }
            }
        }
        System.out.println("Standard logic : " + count_1);

        // HashSet 풀이법
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        System.out.println("set logic : " + set.size());

        // 중요 메소드
        set.remove(3);
        System.out.println(set.contains(4));
    }
}
