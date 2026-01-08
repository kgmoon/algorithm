import java.util.*;

class 데이터분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // 컬럼명 -> 인덱스 매핑 
        Map<String, Integer> indexMap = new HashMap<>();
        indexMap.put("code", 0);
        indexMap.put("date", 1);
        indexMap.put("maximum", 2);
        indexMap.put("remain", 3);
        
        int extIdx = indexMap.get(ext);
        int sortIdx = indexMap.get(sort_by);
        
        // 필터링 
        List<int[]> filtered = new ArrayList<>();
        
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filtered.add(row);
            }
        }
        
        // 정렬 
        filtered.sort(Comparator.comparingInt(row -> row[sortIdx]));
        
        return filtered.toArray(new int[0][]);
    }
}
