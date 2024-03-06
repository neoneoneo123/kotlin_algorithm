class Solution {
    fun solution(food: IntArray): String {
        var answer: String = "" 
        var temp: String = ""    
        for (i in 1..food.size - 1) {        
            if(food[i] % 2 == 0) { //이미 짝수이면, 절반만 반복
                for (j in 0..(food[i]) / 2 - 1) {
                    temp += i.toString()
                }
            }
            else { //홀수이면, 1을 빼서 짝수로 만든다음에, 절반만 반복
                for (j in 0..(food[i]-1) / 2 - 1) {
                    temp += i.toString()
                }
            }
        }        
        answer = temp + "0" + temp.reversed()
        return answer
    }
}