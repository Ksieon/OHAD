import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        QuickSort(arr, 0, N-1);
        System.out.println(String.valueOf(arr[K-1]));
    }
    public static void QuickSort(int[] arr, int left, int right) {
        int L = left;
        int R = right;
        int x = arr[(L+R) / 2];
        do {
            while (arr[L] < x) L++;
            while (arr[R] > x) R--;

            if (L <= R)
                swap(arr, L++, R--);
        } while (L <= R);
        if (left < R) QuickSort(arr, left, R);
        if (L > right) QuickSort(arr, L, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}