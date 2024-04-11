class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()        
        var m = arr1.size
        var n = arr1[0].size
        var q = arr2[0].size
                
        for (i in 0 until m) {
            var tempArray = intArrayOf()
            for (j in 0 until q) {
                var sum = 0
                for (k in 0 until n) {
                    sum += arr1[i][k] * arr2[k][j]
                }
                tempArray += sum
            }
            answer += tempArray
        }  
        return answer
    }
}