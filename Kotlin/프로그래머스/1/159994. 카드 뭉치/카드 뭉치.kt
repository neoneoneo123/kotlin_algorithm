import java.util.Stack

class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = ""
        var goalCheck: MutableList<String> = goal.toMutableList()
        var sortedCards1 = cards1.reversed()
        var sortedCards2 = cards2.reversed()
        var cardStack1 = Stack<String>()
        var cardStack2 = Stack<String>()
        
        sortedCards1.forEach {
            cardStack1.push(it)
        }
        sortedCards2.forEach {
            cardStack2.push(it)
        }
        
        goal.forEach {
            if (cardStack1.isNotEmpty() && it == cardStack1.peek()) {
                goalCheck.remove(cardStack1.peek())
                cardStack1.pop()
                
            } else if (cardStack2.isNotEmpty() && it == cardStack2.peek()) {
                goalCheck.remove(cardStack2.peek())
                cardStack2.pop()
            }
        }
        
        if (goalCheck.isEmpty()) {
            answer += "Yes"
        } else {
            answer += "No"
        }
              
        return answer
    }
}