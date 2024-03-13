class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 1
        //
        
        var start = section[0]
        
        section.forEach {
            if (start + (m - 1) < it) {
                start = it
                answer++
            }
        }
        
        return answer
    }
}