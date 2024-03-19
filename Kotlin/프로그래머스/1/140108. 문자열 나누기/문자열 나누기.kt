/*
0. strX는 s[0], isX는 1, isNotX는 0으로 초기화한다.
1. strX, i+1 인덱스 값을 비교한다.
1-1. 같다면 isX에 값을 더한다.
1-2. 다르다면 isNotX에 값을 더한다.

2. isX와 isNotX를 비교한다.
2-1. 같다면 isX, isNotX를 초기화한다.
     다음 인덱스부터 시작하도록 i++한다.
     strX은 i+1번째 인덱스 값으로 초기화한다.

3. s가 한 문자일 경우에는 1로 리턴한다.

        b a n a n a
   isX  1   1   1
isNotX    1   1   1
answer    1   2   3

*/
class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0       
        var isX = 1
        var isNotX = 0
        var strX = s[0]
        
        var i = 0
        while(i < s.length - 1) {
            if (strX == s[i + 1]) isX++
            else isNotX++
            
            if (isX == isNotX) {
                answer++
                isX = 1
                isNotX = 0
                i++
                
                if(i + 1 < s.length) strX = s[i + 1]
            }
            i++
            
            if(i == s.length - 1) answer++
        }
        
        if (s.length - 1 == 0) answer++
                
        return answer
    }
}