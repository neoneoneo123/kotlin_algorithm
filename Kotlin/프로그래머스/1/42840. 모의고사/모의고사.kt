class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        val supo1 = intArrayOf(1, 2, 3, 4, 5)
        val supo2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val supo3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        
        val supoRank = intArrayOf(0, 0, 0)
        
        for (i in answers.indices) {
            if (answers[i] == supo1[i % supo1.size]) supoRank[0]++
            if (answers[i] == supo2[i % supo2.size]) supoRank[1]++
            if (answers[i] == supo3[i % supo3.size]) supoRank[2]++
        }
        
        val maxScore = supoRank.maxOrNull()
        var answerList = mutableListOf<Int>()
        
        for (i in supoRank.indices) {
            if (supoRank[i] == maxScore) answerList.add(i + 1)
        }
        
        return answerList.toIntArray()
    }
}