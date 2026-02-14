import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int result = solve(n);
        System.out.println(result);
    }


    private static int solve(int n) {
        // 5kg 봉지를 최대한 많이 사용하고 나머지를 3kg로 채울 수 있는지 확인
        for (int five = n / 5; five >= 0; five--) {
            int remainder =  n - (five * 5);

            if (remainder % 3 == 0) {
                return five + (remainder / 3);
            }
        }
        return -1;
    }
}
