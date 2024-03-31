class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf(0, 0)        
        var strData = s
        
        while(true) {          
            if (strData == "1") break
            
            var changedStr = ""
            strData.forEachIndexed { idx, c ->
                if (c == '1') changedStr += c
                else answer[1]++
            }
            
            strData = Integer.toBinaryString(changedStr.length)
            answer[0]++
        }
        
        return answer
    }
}