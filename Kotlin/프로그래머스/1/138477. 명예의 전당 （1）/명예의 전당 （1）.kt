class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var hof: IntArray = intArrayOf()       
        score.forEach {
            hof += it
            var tempHof: IntArray = hof.sortedDescending().take(k).toIntArray()
           answer += tempHof.minOrNull()!!
        }     
        return answer
    }
}