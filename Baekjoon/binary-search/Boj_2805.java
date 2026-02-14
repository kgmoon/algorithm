import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int[] trees = new int[n];
        int maxH = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            trees[i] = h;
            if (h > maxH) maxH = h;
        }

        int lo = 0;
        int hi = maxH;
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long wood = countAmount(trees, mid);

            if (wood >= m) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static long countAmount(int[] trees, int height) {
        long total = 0;
        for (int t : trees) {
            if (t > height) total += (t - height);
        }
        return total;
    }
}
