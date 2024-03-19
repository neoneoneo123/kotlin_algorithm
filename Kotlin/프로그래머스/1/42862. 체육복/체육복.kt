/*
1. 학생 수 만큼 리스트를 만들고 각 학생 별 체육복 수량을 저장해둔다.
2. 체육복 수량의 i, i+1 값을 비교하면서 2-0 조합의 경우 1씩 나눠가진다.
*/

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0        
        var spare: MutableList<Int> = MutableList(n) { 0 }
        
        for (i in 0..n - 1) {
            if (reserve.contains(i + 1) && lost.contains(i + 1)) spare[i] += 1
            else if (reserve.contains(i + 1)) spare[i] += 2
            else if (lost.contains(i + 1)) spare[i] = 0
            else spare[i] += 1
        }
        
        for (i in 0..n - 2) {
            if (spare[i] > spare[i + 1] && spare[i] == 2 && spare[i + 1] == 0) {
                spare[i]--
                spare[i + 1]++
            } else if (spare[i] < spare[i + 1] && spare[i + 1] == 2 && spare[i] == 0) {
                spare[i  + 1]--
                spare[i]++
            }
        }

        answer = spare.count { it >= 1 }
                
        return answer
    }
}