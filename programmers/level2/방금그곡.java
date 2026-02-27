import java.util.*;

class 방금그곡 {

    public String solution(String m, String[] musicInfos) {
        // 기억한 멜로디의 #음을 소문자 한글자로 치환 
        String melody = replaceSharp(m);
        
        String answer = "(None)";
        int maxPlayTime = -1;
        
        for (String musicInfo : musicInfos) {
            String[] info = musicInfo.split(",");
            
            // 재생시간 계산 
            int playTime = calculatePlayTime(info[0], info[1]);
            String title = info[2];
            String sheet = replaceSharp(info[3]);
            
            // 실제 재생된 멜로디 생성 
            String playedMusic = buildPlayedMusic(sheet, playTime);
            
            // 우선순위 판단 
            if (playedMusic.contains(melody) && playTime > maxPlayTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }
        
        return answer;
    }


    private String replaceSharp(String music) {
        return music.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#","g")
                    .replace("A#", "a");
    }
    
    private int calculatePlayTime(String start, String end) {
        int startMin = toMinutes(start);
        int endMin = toMinutes(end);
        return endMin - startMin;
    }
    
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    // 악보를 재생시간만큼 반복/잘라서 실제 재상된 멜로디 생성 
    private String buildPlayedMusic(String sheet, int playTime) {
        StringBuilder sb = new StringBuilder(playTime);
        int sheetLen = sheet.length();
        
        for (int i = 0; i < playTime; i++) {
            sb.append(sheet.charAt(i % sheetLen));
        }
        
        return sb.toString();
    }

}
