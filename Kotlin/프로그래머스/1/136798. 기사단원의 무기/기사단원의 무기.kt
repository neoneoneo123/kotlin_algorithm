class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var mulist = MutableList(number + 1) { 0 } //number 개수의 기사단원 생성
        
        for (i in 1 .. number) { //기사 단원을 한 명씩 돌면서
            if (i == 1)  {
                mulist[i] = 1
            }
            else if (i == 2 || i == 3) {
                mulist[i] = 2
            }
            else {
                var temp = kotlin.math.sqrt(i.toDouble()).toInt()
                for (j in 1 .. temp) {                               
                    if (j * j == i) mulist[i]++
                    else if (i % j == 0) mulist[i] += 2
                }
            }
            if (mulist[i] > limit ) mulist[i] = power
        }
        
        return mulist.sum()
    }
}