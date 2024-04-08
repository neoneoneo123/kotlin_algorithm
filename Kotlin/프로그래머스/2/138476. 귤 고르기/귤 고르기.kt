class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        
        var maxSize = tangerine.maxOrNull() ?: 1
        var sizeCount : MutableList<Int> = MutableList(maxSize) { 0 }

        
        tangerine.forEachIndexed { i, it ->
            sizeCount[it - 1]++
        }
        
        sizeCount.sortDescending()
        
        var rest = k
        for (i in 0 until sizeCount.size) {
            if (rest > 0) {
                rest = rest - sizeCount[i]
                answer++
            } else {
                break
            }
        }
        
        return answer
    }
}