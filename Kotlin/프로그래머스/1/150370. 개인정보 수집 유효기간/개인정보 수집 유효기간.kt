/*
1. privacies를 하나씩 순회한다.
2. 해당 약관을 확인한다.
3. 해당 약관의 유효기간을 확인한다.
4. 유효기간이 지났으면 해당 번호를 answer에 적립한다.
*/


import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
        val todayDate = LocalDate.parse(today, formatter)
        
        privacies.forEachIndexed { idx, privacy ->
            val userTerm = privacy.last()
            val collectionDate = LocalDate.parse(privacy.split(" ").first(), formatter)
            
            terms.forEach { term ->
                if (userTerm == term.first()) {
                    val month = term.split(" ").last().toLong()
                    var validDate = collectionDate.plusMonths(month)
                    
                    if (validDate.dayOfMonth == 1) { validDate = validDate.minusMonths(1).withDayOfMonth(28) }
                    else { validDate = validDate.minusDays(1) }
                                        
                    if (todayDate.compareTo(validDate) > 0) {
                        answer += idx + 1
                    }
                }
            }
        }
        
        return answer
    }
}
