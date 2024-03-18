class Solution {
    fun solution(X: String, Y: String): String {
        var answer: String = ""
        
        var xArr = IntArray(10)
        var yArr = IntArray(10)
        
        for (digit in X) {
            xArr[ (digit - '0') ]++ //'0' = 48, 48을 빼면 숫자 값 얻음
        }
        
        for (digit in Y) {
            yArr[ (digit - '0') ]++
        }
        
        for (i in 9 downTo 0) {
            if (xArr[i] != 0 && yArr[i] != 0) {
                var minCnt = kotlin.math.min(xArr[i], yArr[i])
                answer += i.toString().repeat(minCnt)
            }
        }
        
        if(answer == "") return "-1"
        if(answer[0] == '0') return "0"
        
        return answer
    }
}