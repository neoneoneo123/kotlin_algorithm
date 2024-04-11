class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = intArrayOf()
        
        for (i in left .. right) {
            var divide = i / n
            var mod = i % n
            if (divide >= mod) {
                answer += (divide + 1).toInt()
            }
            else {
                answer += (mod + 1).toInt()
            }
        }
        
        return answer
    }
}