/*
최저 : 0 제외한 것들 중 매칭 되는 개수로 판단
최고 : 최저 등수와 0 개수로 판단

1 2 3 4 5 6
0 0 3 4 5 6 -> 최저 : 4개는 매칭(3등)
            -> 최고 : 0 자리가 1, 2일 경우 6개 매칭(1등)
*/

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var zeros = 0; var lowest = 7; var highest = 7      
        lottos.forEach { lotto ->
            win_nums.forEach { winNum ->
                if (lotto == winNum) {
                    lowest--
                }
            }
            if (lotto == 0) zeros++
        }
                
        highest = lowest - zeros
        
        if(highest == 7) highest--
        if(lowest == 7) lowest--
        
        return intArrayOf(highest, lowest)
    }
}