import java.util.Stack

class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var cardStack1 = Stack<String>().apply { cards1.reversed().forEach { push(it) } }
        var cardStack2 = Stack<String>().apply { cards2.reversed().forEach { push(it) } }
        val goalCheck = ArrayList<String>(goal.toList())
        
        goal.forEach {
            when {
                cardStack1.isNotEmpty() && it == cardStack1.peek() -> {
                    goalCheck.remove(cardStack1.peek())
                    cardStack1.pop()
                }
                cardStack2.isNotEmpty() && it == cardStack2.peek() -> {
                    goalCheck.remove(cardStack2.peek())
                    cardStack2.pop()
                }
            }
        }
                
        return if (goalCheck.isEmpty()) "Yes" else "No"
    }
}