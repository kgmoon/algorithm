import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1244 {

    private static int[] switches;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수
        N = Integer.parseInt(br.readLine());
        switches = new int [N + 1];

        // 초기 스위치 상태
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수
        int students = Integer.parseInt(br.readLine());

        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                toggleByMultiples(number);
            } else {
                toggleBySymmetric(number);
            }
        }

        printResult();

    }

    // 남학생 : 번호의 배수에 해당하는 스위치 상태 변경
    private static void toggleByMultiples(int number) {
        for (int i = number; i <= N; i += number) {
            toggle(i);
        }
    }

    // 여학생 : 기준 번호를 중심으로 좌우 대칭 구간 상태 변경
    private static void toggleBySymmetric(int center) {
        toggle(center);

        int left = center - 1;
        int right = center + 1;

        while (left >= 1 && right <= N && switches[left] == switches[right]) {
            toggle(left);
            toggle(right);
            left--;
            right++;
        }
    }

    // 스위치 상태 변경
    private static void toggle(final int i) {
        switches[i] = 1 - switches[i];
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(switches[i]);

            if (i % 20 == 0) {
                sb.append('\n');
            } else if (i != N) {
                sb.append(' ');
            }
        }
        System.out.println(sb);
    }
}
