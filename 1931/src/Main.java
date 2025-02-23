import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static int[][] meetingList;
    static int caculateMeetingCount(){
        //현재까지 미팅이 끝나는 시간
        int nowTime = 0; 
        //이전 미팅이 사용한 시간
        int useTime = 0;
        //회의실 사용한 미팅 개수 
        int countMeeting = 0;
        for(int[] meeting : meetingList){
            //현재 미팅의 시작 시간과 끝나는 시간
            int startTime = meeting[0];
            int endTime = meeting[1];
            //아직 시작한 미팅이 없다면 우선 첫번째 타임을 회의실 사용에 체크
            if(countMeeting==0){
                nowTime = endTime;
                useTime = endTime-startTime;
                countMeeting++;
            } else if (startTime>=nowTime){ //만약 미팅이 사용 가능한 시간이라면
                nowTime = endTime;
                useTime = endTime-startTime;
                countMeeting++;
            } else { //사용 불가능한 시간이라면, 이전 미팅 시간과 비교하여 회의실 사용을 교체(countMeeting값은 늘리지 않고, 나머지 값들만 교체)
                if(useTime>endTime-startTime){
                    nowTime = endTime;
                    useTime = endTime-startTime;
                }
            }
        }
        return countMeeting;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        meetingList = new int[N][2];
        
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            meetingList[i][0] = Integer.parseInt(st.nextToken());
            meetingList[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meetingList, 0, N, 
                Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt((int[] a) -> a[1])
        );

        System.out.println(caculateMeetingCount());
    }
}