class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        
        commands.forEach {
            var temp = (array.sliceArray(it[0] - 1 .. it[1] - 1))
            temp.sort()  
            
            answer += temp[it[2] - 1]
        }
        
        return answer
    }
}