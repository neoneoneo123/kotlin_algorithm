class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        var daysMap: Map<Int, String> = mapOf (
            0 to "SAT", 1 to "SUN", 2 to "MON", 3 to "TUE",
            4 to "WED", 5 to "THU", 6 to "FRI"
        ) 
        
        var h = 0
        var date = b
        var month = a
        var year = 2016
        
        if (month < 3) {
            month += 12
            year--
        }
        
        h = (date + (13 * (month + 1) / 5) + year + (year / 4) - (year / 100) + (year / 400)) % 7
                
        answer = daysMap[h].toString()
        
        return answer
    }
}