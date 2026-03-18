import java.util.Arrays;
import java.util.PriorityQueue;

class 호텔대실 {
    public int solution(String[][] book_time) {
        // 시작 시간 기준으로 정렬
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        // 가장 빨리 끝나는 방의 종료 시각을 관리 하는 최소 힙 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String[] book : book_time) {
            int start = toMinutes(book[0]);
            int end = toMinutes(book[1]) + 10;
            
            // 기존 방 재사용 가능 여부 확인
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); // 가장 빨리 끝난 방 빼고 
            }
            pq.offer(end); // 새 예약 종료 시각으로 갱신 또는 새 방 추가
        }
        
        // 남아있는 방의 수 = 필요한 최소 객실 수 
        return pq.size();
    }
    
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
