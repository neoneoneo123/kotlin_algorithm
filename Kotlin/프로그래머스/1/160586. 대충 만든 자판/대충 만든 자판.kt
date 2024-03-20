/*
1. target char를 포함하는 키가 있는가?
    F -> -1 추가. 이번 target 끝
    T -> 포함하는 키들의 몇 번째 인덱스에 있는가?
        -> 더 작은 인덱스 + 1 추가    
*/

class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
              
        for (i in 0 until targets.size) {
            var pushCount = 0
            for (j in 0 until targets[i].length) {
                var compareCount: MutableList<Int> = mutableListOf()
                for (k in 0 until keymap.size) {
                    if (keymap[k].contains(targets[i][j])) {                  
                        compareCount.add(keymap[k].indexOf(targets[i][j]))
                    }
                }
                if (compareCount.size >= 1) {
                    pushCount += compareCount.minOrNull()!! + 1
                    compareCount.clear()
                } else {
                    pushCount = -1
                    break
                }
            }
            answer += pushCount
        }
                
        return answer
    }
}