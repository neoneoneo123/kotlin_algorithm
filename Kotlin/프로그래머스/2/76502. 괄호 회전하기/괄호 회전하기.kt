import java.util.Stack

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var changedStr = s
        
        changedStr.forEach {
            if (check(changedStr)) answer++
            changedStr = rotate(changedStr)
        }       
        return answer
    }
    
    fun check(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            when (it) {
                '(', '[', '{' -> stack.push(it)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            }
        }
        return stack.isEmpty()
    }
    
    fun rotate(s: String): String {
        return (s + s.first()).takeLast(s.length)
    }
}