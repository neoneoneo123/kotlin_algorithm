/*
A = 65 | Z = 90
a = 97 | z = 122
*/

class Solution {
    fun solution(s: String): String {
        var answer = ""       
        var strList = s.split(" ").map { it }
        
        strList.forEachIndexed { i, str ->            
            var temp = ""
            str.forEachIndexed { idx, char ->
                val asciiChar = char.toInt()
                if (idx == 0) {
                    if (asciiChar >= 97 && asciiChar <= 122) { //소문자면 대문자로 변환
                        temp += char.toUpperCase()
                    } else temp += char
                } else {
                    if (asciiChar >= 65 && asciiChar <= 90) { //대문자면 소문자로 변환
                        temp += char.toLowerCase()
                    } else temp += char
                }
            }
            if (i == strList.size - 1) answer += temp
            else answer += (temp + " ")
        }
        
        return answer
    }
}