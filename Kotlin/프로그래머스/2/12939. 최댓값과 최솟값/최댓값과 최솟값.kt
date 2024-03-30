/*
최솟값은 min
최댓값은 max 쓰면 되는거 아닌가..?
공백이 들어있어서 공백을 제외하고 생각해야함
음수는 -를 처리해줘야함
*/

class Solution {
    fun solution(s: String): String {
        var answer = ""
        var numberList : MutableList<Int> = mutableListOf()
        
        var i = 0
        while (i < s.length) {
            
            if (s[i] == ' ') {
                continue
            }
            
            //-가 나오면 다음 공백이 나올 때까지만 잘라야함
            var temp = ""
            if (s[i] == '-') {                
                temp += s[i]
                var end = true
                var j = i + 1
                while(end) {
                    if (j < s.length) {
                        if (s[j] == ' ') {
                            end = false
                        } else if (s[j] != ' ') {
                            temp += s[j]
                        }
                    } else {
                        end = false
                    }
                    j++
                }
                i = j - 1
            }
            //-가 없으면 다음 공백이 나올 때까지만 잘라야함
            else {
                temp += s[i]
                var end = true
                var j = i + 1
                while(end) {
                    if (j < s.length) {
                        if (s[j] == ' ') {
                            end = false
                        } else if (s[j] != ' ') {
                            temp += s[j]
                        }
                    } else {
                        end = false
                    }
                    j++
                }
                i = j - 1
            }
            //println(temp)
            numberList += temp.toInt()
            i++
        }
        
        var min = numberList.minOrNull()!!
        var max = numberList.maxOrNull()!!
        
        answer = min.toString() + " " + max.toString()
        
        return answer
    }
}