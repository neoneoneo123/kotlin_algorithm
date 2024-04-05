class Solution {
    fun solution(n: Int): Long {
        var answer: Long = 0
        
        var list : MutableList<Long> = mutableListOf(1, 2)
        for (i in 1 until n) {
            var temp: Long = list[1] % 1234567L
            list[1] = list[0] % 1234567L + temp
            list[0] = temp % 1234567L
        }
        
        answer = list[0]
        
        return answer
    }
}