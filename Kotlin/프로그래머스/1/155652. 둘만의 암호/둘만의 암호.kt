class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        
        val alphabets = ('a'..'z').filter { !skip.contains(it) }.sorted()
        val alphaLength = alphabets.size
        
        s.forEach {
            answer += alphabets[(alphabets.indexOf(it) + index) % alphaLength]
        }
        
        return answer
    }
}