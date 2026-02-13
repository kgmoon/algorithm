import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        // dp[i] = arr[i]를 마지막 원소로 하는 LIS의 길이
        int[] dp = new int[n];
        int lisLength = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 자기 자신만 포함하는 경우
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            lisLength = Math.max(lisLength, dp[i]);
        }
        System.out.println(n - lisLength);
    }
}
