class 이웃한칸 {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        String targetColor = board[h][w];
        int count = 0;
        
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            
            // 범위 체크
            if (nh >= 0 && nh < n && nw >= 0 && nw < n) {
                if (targetColor.equals(board[nh][nw])) {
                    count++;
                }
            }
        }
        return count;
    }
}
