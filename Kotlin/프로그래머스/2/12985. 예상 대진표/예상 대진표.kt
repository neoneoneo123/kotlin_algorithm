class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var newA = a
        var newB = b
        
        while(newA != newB) {
            newA = if (newA % 2 == 0) newA / 2 else newA / 2 + 1
            newB = if (newB % 2 == 0) newB / 2 else newB / 2 + 1
            answer++
        }

        return answer
    }
}