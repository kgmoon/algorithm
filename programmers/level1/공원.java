import java.util.Arrays;

class 공원 {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;
        
        // 큰 돗자리부터 시도해서 배치 성공하면 정답 
        Arrays.sort(mats);
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int size = mats[idx];
            
            if (size > rows || size > cols) {
                continue;
            }
            
            if (canPlace(park, rows, cols, size)) {
                return size;
            }
        }
        
        return -1;
    }
    
    
    // park 내에 size * size 크기의 빈 정사각형 영역이 존재하는지 확인 
    private boolean canPlace(String[][] park, int rows, int cols, int size) {
        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                if (isAllEmpty(park, i, j, size)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // (startRow, startCol)부터 size * size 영역이 모두 빈칸인지(-1) 검사
    private boolean isAllEmpty(String[][] park, int startRow, int startCol, int size) {
        for (int r = startRow; r < startRow + size; r++) {
            for (int c = startCol; c < startCol + size; c++) {
                if(!"-1".equals(park[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }
}
