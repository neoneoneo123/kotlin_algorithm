class Solution {
    fun solution(s: String): String {        
        var list = s.split(" ").map { it.toInt() }        
        return list.minOrNull()!!.toString() + " " + list.maxOrNull()!!.toString()
    }
}