import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Important
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            String cmd = st.nextToken();

            if(cmd.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }
            else if(cmd.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(stack.pop()).append("\n");
                }
            }
            else if(cmd.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(cmd.equals("empty")){
                if(stack.empty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if(cmd.equals("top")){
                if(stack.empty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
