class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0
        
        var tempLcm = lcm(arr[0], arr[1])
        for (i in 0 until arr.size - 1) {
            answer = lcm(tempLcm, arr[i + 1])
            tempLcm = answer
        }
        
        return answer
    }
    
    fun lcm(a: Int, b: Int): Int {
        var c = gcd(a, b)
        return a * b / c
    }
    
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}