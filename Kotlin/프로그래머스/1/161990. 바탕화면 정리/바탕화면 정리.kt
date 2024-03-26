/*
1. #의 좌표 값을 별도의 변수에 저장한다. [x, y]...
2. x 값 중 가장 작은 것을 찾아 저장한다.
2. y 값 중 가장 작은 것을 찾아 저장한다.
2. x 값 중 가장 큰 것을 찾아 +1 하여 저장한다.
2. y 값 중 가장 큰 것을 찾아 +1 하여 저장한다.
*/

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var sharpSite: MutableList<Pair<Int, Int>> = mutableListOf()
        
        //#의 좌표 값 저장
        wallpaper.forEachIndexed { x, xItem ->
            xItem.forEachIndexed { y, yItem ->
                if(yItem == '#') {
                    sharpSite.add(x to y)
                }
            }
        }
        
        //최소, 최대 값 탐색       
        answer += sharpSite.map { it.first }.minOrNull()!!
        answer += sharpSite.map { it.second }.minOrNull()!!
        answer += sharpSite.map { it.first }.maxOrNull()!! + 1
        answer += sharpSite.map { it.second }.maxOrNull()!! + 1
        
        return answer
    }
}
