class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        // 이름을 키로하고 순서를 값으로하는 맵 생성
        val playerMap = mutableMapOf<String, Int>()
        players.forEachIndexed { index, player -> playerMap[player] = index }

        // 불리는 순서대로 플레이어 이동
        callings.forEach { calling ->
            val currentIndex = playerMap[calling]!!
            if (currentIndex > 0) { // 맨 앞 플레이어는 이동할 필요 없음
                val prevPlayer = players[currentIndex - 1]
                playerMap[prevPlayer] = currentIndex // 앞의 플레이어를 현재 위치로 이동
                playerMap[calling] = currentIndex - 1 // 현재 플레이어를 앞으로 이동
                players[currentIndex] = prevPlayer // 배열에서도 위치 변경
                players[currentIndex - 1] = calling // 배열에서도 위치 변경
            }
        }
        
        return players
    }
}
