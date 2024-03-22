class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        var items = ingredient.toMutableList()
        var pattern = listOf(1, 2, 3, 1)
        
        var i = 0
        while (i < items.size - pattern.size + 1) {
            //println(i)
            if (i >= 0) {
                //println(items.subList(i, i + pattern.size))
                if (items.subList(i, i + pattern.size) == pattern) {
                    //println("패턴 발견: $i")               
                    answer++
                    items.subList(i, i + pattern.size).clear()
                    i -= pattern.size - 1 // 패턴의 다음 요소부터 검사하기 위해 패턴 크기 - 1만큼 감소
                }
            }
            i++
        }
        
        return answer
    }
}