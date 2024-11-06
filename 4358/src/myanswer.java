import java.util.*;
import java.io.*;

public class myanswer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>(); // 
        int countTree = 0;
        while(true){
            String str = br.readLine();
            if(str.equals("")){
                break;
            }
            if(!map.containsKey(str)){
                map.put(str, 1);
            }
            else{
                int countBell = map.get(str);
                map.put(str, ++countBell);
            }
            countTree++;
        }
        ArrayList<String> keylist = new ArrayList<>(map.keySet()); 
        Collections.sort(keylist); 
        Iterator<String> it = keylist.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            String s1 = it.next();
            int numOfBell = map.get(s1);
            String percent = String.format("%.4f", ((float)(numOfBell)/countTree)*100);
            sb.append(s1).append(" ").append(percent).append("\n");
        }
        System.out.println(sb.toString());
    }
}
