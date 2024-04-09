class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0                
        var h = 0
        
        for (i in 1 .. citations.size) {
            var cnt = citations.filter { it >= i }.count()
            
            if (cnt >= i) h = i
            else answer = h
        }
                
        return if (answer == 0) h else answer
    }
}