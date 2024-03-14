class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var charBox : MutableSet<Char> = mutableSetOf() //나온 글자 보관함
        
        for (i in 0 .. s.length - 1) {
            if (!charBox.contains(s[i])) {
                charBox.add(s[i])
                answer += -1            
            } else {
                var j = i - 1
                while(j > -1) {
                    if(s[i] == s[j]) {
                        answer += i - j
                        j--
                        break
                    }
                    j--
                }
            }
        }    
        return answer
    }
}