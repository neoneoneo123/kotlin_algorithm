class Solution {
    fun solution(s: String): String {
        var numberList : MutableList<Int> = mutableListOf()        
        var i = 0
        while (i < s.length) {            
            if (s[i] == ' ') continue
            var temp = "" + s[i]
            var end = true
            var j = i + 1
            while(end) {
                if (j < s.length) {
                    if (s[j] == ' ') end = false
                    else if (s[j] != ' ') temp += s[j]
                } else end = false
                j++
            }
            i = j        
            numberList += temp.toInt()
        }                
        return numberList.minOrNull()!!.toString() + " " + numberList.maxOrNull()!!.toString()
    }
}