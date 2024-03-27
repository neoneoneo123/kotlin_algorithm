class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        
        val playerMap = mutableMapOf<String, Int>()
        players.forEachIndexed { index, value -> playerMap[value] = index}
        
        callings.forEach { call ->
            val idx = playerMap[call]!! //현재 인덱스
            if (idx > 0) {
                val prevPlayer = players[idx - 1] //앞 선수의 이름
                playerMap[prevPlayer] = idx //앞 선수의 순번을 불린 선수 것으로 변경
                players[idx] = prevPlayer //배열상 앞 선수의 위치를 불린 선수 위치로 변경
                
                playerMap[call] = idx - 1 //불린 선수의 순번에서 1 빼기
                players[idx - 1] = call //배열상 불린 선수의 위치를 한칸 앞으로 변경
            }
        }
        return players
    }
}
