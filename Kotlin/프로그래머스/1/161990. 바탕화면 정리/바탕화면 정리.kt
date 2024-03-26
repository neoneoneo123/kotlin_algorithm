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
