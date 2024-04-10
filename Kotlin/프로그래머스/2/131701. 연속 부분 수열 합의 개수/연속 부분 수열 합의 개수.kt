// 0  1  2  3  4
// 7  9  1  1  4
// 7+9 9+1 1+1 1+4 4+7
// 7+9+1 9+1+1 1+1+4 1+4+7 4+7+9 
// 7+9+1+1 9+1+1+4 1+1+4+7 1+4+7+9 4+7+9+1 

// 7+9+1+1+4

// 더할 개수는 1 ~ size 개 가능
// 데이터는 set으로 저장하여 중복 제거

class Solution {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0
        var sum = mutableSetOf<Int>()
        var size = elements.size
        var dobleElements = elements + elements //순환하기 위해 이어 붙임
        
        for (i in 0 until size) { //size 개수 만큼 반복
            for (j in 0 until size) { //더할 수의 개수 만큼 반복
                var temp = 0
                for (k in j .. j + i) { 
                    temp += dobleElements[k] //한 칸씩 이동된 값을 누적
                }
                sum.add(temp)
            }
        }
        answer = sum.size
        return answer
    }
}