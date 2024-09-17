import java.util.Scanner;

class Stack_{
    int top = -1;
    int[] a= new int[10000];

    public int empty(){
        if(top==-1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void push(int x){
        a[++top] = x;
    }
    public int pop(){
        if(this.empty()==1){
            return -1;
        }
        else{
            return a[top--];
        }
    }
    public int size(){
        return (top+1);
    }
    public int top(){
        if(this.empty()==1){
            return -1;
        }
        else{
            return a[top];
        }
    }
}

public class Myanswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack_ stack = new Stack_();
        int c = sc.nextInt();
        for(int i=0; i<c; i++){
            String com = sc.next();
            if(com.equals("push")){
                int num = sc.nextInt();
                stack.push(num);
            }
            else if(com.equals("pop")){
                System.out.println(stack.pop());
            }
            else if(com.equals("size")){
                System.out.println(stack.size());
            }
            else if(com.equals("empty")){
                System.out.println(stack.empty());
            }
            else if(com.equals("top")){
                System.out.println(stack.top());
            }
        }
    }
}