class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        var items = ingredient.toMutableList()
        var pattern = listOf(1, 2, 3, 1)       
        var i = 0
        while (i <= items.size - 4) {
            if (i >= 0) {
                if (items.subList(i, i + 4) == pattern) {
                    answer++
                    items.subList(i, i + 4).clear()
                    i -= 5
                }
            }
            i++
        }        
        return answer
    }
}