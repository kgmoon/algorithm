import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 전체 문자열에서 'a'의 개수 세기
        int aCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        if (aCount == 0) {
            System.out.println(0);
            return;
        }

        int bCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            }
        }

        int minSwap = bCount;

        // 슬라이딩 윈도우 
        for (int i = 1; i < s.length(); i++) {
            // 이전 문자 제거
            if (s.charAt(i - 1) == 'b') {
                bCount--;
            }
            // 새로운 문자 추가
            if (s.charAt((i + aCount - 1) % s.length()) == 'b') {
                bCount++;
            }
            minSwap = Math.min(minSwap, bCount);
        }
        System.out.println(minSwap);
    }
}
