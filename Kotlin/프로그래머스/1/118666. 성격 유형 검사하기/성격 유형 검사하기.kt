class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        var tempList: MutableList<MutableList<Pair<Char, Int>>> = mutableListOf()
        
        //점수 변환 파트
        for (i in 0 until choices.size) {         
            if (choices[i] < 4) { //4점 이하일 때(앞의 캐릭터 유형에 점수)
                var tempScore = 0
                when (choices[i]) {
                    1 -> tempScore = 3
                    2 -> tempScore = 2
                    3 -> tempScore = 1
                }
                tempList.add(mutableListOf(survey[i][0] to tempScore))
            }
            else if (choices[i] > 4) { //4점 이상일 때(뒤의 캐릭터 유형에 점수)
                var tempScore = choices[i] - 4
                tempList.add(mutableListOf(survey[i][1] to tempScore))
                
            }
            else { //4점일 때
                var tempChar = if (survey[i][0].compareTo(survey[i][1]) < 0) survey[i][0] else survey[i][1] //사전순으로 빠른 캐릭터의 0점을 넘겨준다.
                tempList.add(mutableListOf(tempChar to 0))
            }
        }
        
        //점수 누적 파트
        var tempCharList: MutableList<Pair<Char, Int>> = mutableListOf(
            'R' to 0, 'T' to 0,
            'C' to 0, 'F' to 0,
            'J' to 0, 'M' to 0,
            'A' to 0, 'N' to 0,
        )
        
        for (i in 0 until tempList.size) {
            if (tempList[i][0].first == 'R') tempCharList[0] = tempCharList[0].copy(second = tempCharList[0].second + tempList[i][0].second)
            if (tempList[i][0].first == 'T') tempCharList[1] = tempCharList[1].copy(second = tempCharList[1].second + tempList[i][0].second)
            if (tempList[i][0].first == 'C') tempCharList[2] = tempCharList[2].copy(second = tempCharList[2].second + tempList[i][0].second)
            if (tempList[i][0].first == 'F') tempCharList[3] = tempCharList[3].copy(second = tempCharList[3].second + tempList[i][0].second)
            if (tempList[i][0].first == 'J') tempCharList[4] = tempCharList[4].copy(second = tempCharList[4].second + tempList[i][0].second)
            if (tempList[i][0].first == 'M') tempCharList[5] = tempCharList[5].copy(second = tempCharList[5].second + tempList[i][0].second)
            if (tempList[i][0].first == 'A') tempCharList[6] = tempCharList[6].copy(second = tempCharList[6].second + tempList[i][0].second)
            if (tempList[i][0].first == 'N') tempCharList[7] = tempCharList[7].copy(second = tempCharList[7].second + tempList[i][0].second)
        }
        
        
        //성격 유형 결정 파트
        var tempResult = "OOOO"
        for (i in 0 until 8 step 2) {
            println("${tempCharList[i].second}     ${tempCharList[i+1].second}")
            if (tempCharList[i].second > tempCharList[i+1].second) {
                tempResult = tempResult.replaceRange(i/2, i/2+1, tempCharList[i].first.toString())
            }
            else if (tempCharList[i].second < tempCharList[i+1].second) {
                tempResult = tempResult.replaceRange(i/2, i/2+1, tempCharList[i+1].first.toString())
            }
        }
        
        //성격 유형 보정 파트
        //대답에 특정 유형이 없으면 사전순으로 빠른 캐릭터 줘야함              
        if (tempResult[0] == 'O') {
            tempResult = tempResult.replaceRange(0, 1, "R")
        }
        if (tempResult[1] == 'O') {
            tempResult = tempResult.replaceRange(1, 2, "C")
        }
        if (tempResult[2] == 'O') {
            tempResult = tempResult.replaceRange(2, 3, "J")
        }
        if (tempResult[3] == 'O') {
            tempResult = tempResult.replaceRange(3, 4, "A")
        }
        
        answer = tempResult
        
        return answer
    }
}