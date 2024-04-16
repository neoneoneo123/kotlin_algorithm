/*
1. 모든 가능한 던전 조합 생성 : 던전들의 모든 순열 생성(재귀)
2. 각 순열에 대한 탐험 가능 여부 확인 : 
  2-1. 던전 조합의 순서대로 탐험
  2-2. 현재 피도로로 탐험 가능한지 확인
  2-3. 가능하다면 count에 적립
3. 최대 탐험 가능한 던전 수 계산 : count의 max 값 계산
*/

class Solution {
    
    var dMax = 0
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        
        val dSize = dungeons.size
        val checkedD = BooleanArray(dSize)
        
        permutation(dungeons, checkedD, mutableListOf(), k)
             
        return dMax
    }
    
    private fun permutation(dungeons: Array<IntArray>, checkedD: BooleanArray, order: MutableList<Int>, k: Int) {
        //3.
        if (order.size == dungeons.size) {
            dMax = kotlin.math.max(dMax, exploreD(dungeons, order, k))
            return
        }
        
        //1.
        for (i in dungeons.indices) {
            if (!checkedD[i]) {
                checkedD[i] = true
                order.add(i)
                
                permutation(dungeons, checkedD, order, k)
                
                checkedD[i] = false
                order.removeAt(order.size - 1)
            }
        }
    }
    
    //2.
    private fun exploreD(dungeons: Array<IntArray>, order: MutableList<Int>, k: Int) : Int {
        var currentHp = k
        var count = 0
        
        for (idx in order) {
            val requiredHp = dungeons[idx][0]
            val comsumptionHp = dungeons[idx][1]
            
            if (currentHp >= requiredHp) {
                currentHp -= comsumptionHp
                count++
            } else {
                break
            }
        }
        return count
    }
    
}