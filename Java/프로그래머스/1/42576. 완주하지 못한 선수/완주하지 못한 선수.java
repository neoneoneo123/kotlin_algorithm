import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p: participant) //참여 선수 이름, 동명이인인 경우 +1 해시맵 삽입
            map.put(p, map.getOrDefault(p, 0) + 1);
        
        for (String c: completion) { //완주 선수 이름 제거
            int left = map.get(c);
            if (left == 1)
                map.remove(c);
            else
                map.put(c, left - 1);
        }
        //남아 있는 유일한 키 리턴
        return map.entrySet().iterator().next().getKey();
    }
}