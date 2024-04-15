import java.util.ArrayDeque

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        // 프로세스 정보를 저장하는 Deque
        val deque = ArrayDeque<Pair<Int, Int>>()

        // 프로세스 정보를 Deque에 저장 (우선순위, 인덱스)
        priorities.forEachIndexed { index, priority ->
            deque.offer(Pair(priority, index))
        }

        var order = 0

        // 프로세스 처리
        while (deque.isNotEmpty()) {
            val current = deque.poll() // 가장 앞에 있는 프로세스 꺼내기
            val priority = current.first
            val index = current.second
            var isHigherPrior = false

            // 현재 프로세스보다 높은 우선순위의 프로세스가 있는지 확인
            for (process in deque) {
                if (process.first > priority) {
                    isHigherPrior = true
                    break
                }
            }

            if (isHigherPrior) {
                // 높은 우선순위의 프로세스가 존재하면 다시 뒤로 넣기
                deque.offer(current)
            } else {
                // 높은 우선순위의 프로세스가 없으면 실행 순서 증가
                order++

                // 원하는 위치의 프로세스가 실행되면 순서 반환
                if (index == location) {
                    answer = order
                    break
                }
            }
        }

        return answer
    }
}
