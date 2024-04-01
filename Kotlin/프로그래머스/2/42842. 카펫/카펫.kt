class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        
        var list = mutableListOf<Int>()
        for (i in 1 .. yellow) {
            if ( yellow % i == 0 ) {
                list.add(i)
            }
        }
                
        var last = list.size - 1
        for (i in 0 until (list.size/2)+1) {
            if ((list[i] + 2) * 2 + list[last] * 2 == brown) {
                answer += list[last] + 2
                answer += list[i] + 2
                break
            }
            last--
        }
        
        return answer
    }
}