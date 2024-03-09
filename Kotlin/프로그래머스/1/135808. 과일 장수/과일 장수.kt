class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0   
        var sortedScore = score.sortedDescending()
        
        var idx = 0
        for (i in 0 .. (score.size / m) - 1) {
            val subScore = sortedScore.subList(idx, idx + m)
            answer += subScore.minOrNull()!! * m
            idx += m
        }
        
        return answer
    }
}