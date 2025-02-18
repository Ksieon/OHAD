import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] trees = new int [n+1][2];
        
        StringTokenizer st;
        int total_length = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            trees[i][0] = Integer.parseInt(st.nextToken());
            total_length+=trees[i][0];
        }
        st= new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            trees[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][total_length+1];
        int total_tree = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=total_length; j++){
                if(i==1){
                    dp[i][j] = (j-i) * trees[i][1];
                } else {
                    if(j>trees[i][0]+1){
                        if(j>total_tree){
                            dp[i][j] = Integer.min(dp[i-1][j], Integer.min(dp[i][total_tree] + (j-total_tree) * trees[i][1], dp[1][trees[i][0]+1] + (j-(trees[i][0]+1)) * trees[i][1]));
                        } else {
                            dp[i][j] = Integer.min(dp[i-1][j], dp[1][trees[i][0]+1] + (j-(trees[i][0]+1)) * trees[i][1]); //🔥
                        }
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            total_tree += trees[i][0];
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=total_length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}