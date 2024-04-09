class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0        
        var size = citations.size
        
        var temp = 0
        for (i in 1 .. size) {
            var cnt = citations.filter { it >= i }.count()

            if (cnt >= i) {
                temp = i
            }
            else {
                answer = temp
            }
        }
        
        if (answer == 0) {
            answer = temp
        }
        
        return answer
    }
}