class Solution {
    fun solution(a: Int, b: Int): String {
        var daysMap: Map<Int, String> = mapOf (
            0 to "SAT", 1 to "SUN", 2 to "MON", 3 to "TUE",
            4 to "WED", 5 to "THU", 6 to "FRI"
        )
        
        var m = a
        var y = 2016
        if (m < 3) {
            m += 12
            y--
        }
        
        return daysMap[(b + (13 * (m + 1) / 5) + y + (y / 4) - (y / 100) + (y / 400)) % 7].toString()
    }
}

//https://en.wikipedia.org/wiki/Zeller%27s_congruence