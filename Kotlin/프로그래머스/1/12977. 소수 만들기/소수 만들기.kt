class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        var isPrime = true
        
        for (i in nums.indices) {
            for (j in i+1 .. nums.lastIndex) {
                if (j != nums.lastIndex) {
                   for (k in j+1 .. nums.lastIndex) {
                        val sum = (nums[i] + nums[j] + nums[k])
                        //sum이 2~sum의 제곱근 값으로 나눴을 때에 나머지가 0이되면 소수가 아님
                        isPrime = true
                        for (l in 2 .. (Math.sqrt(sum.toDouble())).toInt()) {
                            if (sum % l == 0) {
                                //println("$sum % $l = ${sum % l} :: 소수 아님")
                                isPrime = false
                            }
                        }
                        if (isPrime) {
                            //println("$sum 은 소수다!")
                            answer++
                        }
                    }
                }
            }
        }
        return answer
    }
}