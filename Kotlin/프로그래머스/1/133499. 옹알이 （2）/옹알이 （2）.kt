class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        var pron = listOf("aya", "ye", "woo", "ma")
        
        for (i in babbling.indices) {
            var temp = babbling[i]
            for (j in pron.indices) {
                if (babbling[i].contains(pron[j] + pron[j])) continue
                else temp = temp.replace(pron[j], " ")
            }
            if (temp.replace(" ", "") == "") answer++
        }
        return answer
    }
}