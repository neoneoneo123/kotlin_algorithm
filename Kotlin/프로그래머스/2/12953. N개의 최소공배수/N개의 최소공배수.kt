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
    
    fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)
    
    tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}