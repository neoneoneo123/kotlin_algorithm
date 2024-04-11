class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        
        //곱한 결과 행렬의 크기 m x q (m x n * p x q)
        var m = arr1.size
        var n = arr1[0].size
        var q = arr2[0].size
        
        //println("새로운 행렬의 크기는? : $m x $q ")
        
        for (i in 0 until m) {
            var tempArray = intArrayOf()
            for (j in 0 until q) {
                var temp = 0
                for (k in 0 until n) {
                    //println("i = $i | j = $j | k = $k")
                    temp += arr1[i][k] * arr2[k][j]
                }
                //println("여기까지 하나 계산! : $temp")
                tempArray += temp
            }
            answer += tempArray
        }
        
        
        return answer
    }
}