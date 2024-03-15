class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var muWinNums = win_nums.toMutableList()
        var lowest = 7
        var highest = 7
        var zeros = 0
        
        //최저등수
        lottos.forEach { lotto ->
            win_nums.forEach { winNum ->
                if (lotto == winNum) {
                    lowest--
                    muWinNums.remove(lotto)
                }
            }
            if (lotto == 0) {
                zeros++
            }
        }
                
        //최고등수
        highest = lowest - zeros
        
        if(highest == 7) highest--
        if(lowest == 7) lowest--
              
        answer += highest
        answer += lowest
        
        println(highest)
        println(lowest)
        
        return answer
    }
}