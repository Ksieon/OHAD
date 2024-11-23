import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 10000;
    static int[] non_self = new int[MAX+1];
    static int count_non_self = 0;
    static boolean first_check = true;
    static int recursive(int i){
        if(first_check){
            if(i/10<1){
                return i+i;
            }
        }
        else{
            if(i/10<1){
                return i;
            }
        }
        int result = 0;
        if(first_check){
            result = i;
            first_check = false;
        }
        result+=i%10;
        int num = (int)(i/10);
        result+=recursive(num);
        return result;
    }
    static boolean find_non_self(int num){
        for(int i=1; i<=MAX; i++){
            if(non_self[i]==num){
                return true;
            }
            else{
                continue;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        for(int i=1; i<=MAX; i++){
            int num = recursive(i);
            if(num<=MAX){
                non_self[i] = num;
                first_check = true; 
            }
            else{
                break;
            }
        }
        for(int i=1; i<=MAX; i++){
            if(find_non_self(i)){
                continue;
            }
            else{
                System.out.println(i);
            }
        }
    }
}
