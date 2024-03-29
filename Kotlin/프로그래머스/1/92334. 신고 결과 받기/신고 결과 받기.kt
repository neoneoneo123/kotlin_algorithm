class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportCount = mutableMapOf<String, Int>().withDefault { 0 } // id별 신고당한 횟수 누적
        val suspendedCount = mutableMapOf<String, Int>().withDefault { 0 } // id별 정지 시킨 이용자 수 누적
        
        var repoToSet = report.toList().distinct()
        
        repoToSet.forEach { reportCount[it.split(" ")[1]] = reportCount.getValue(it.split(" ")[1]) + 1 }

        reportCount.filterValues { it >= k }.forEach { (reported, _) ->
            repoToSet.filter { it.endsWith(" $reported") }
                .map { it.split(" ")[0] }
                .forEach { suspendedCount[it] = suspendedCount.getValue(it) + 1 }
        }

        return id_list.map { suspendedCount.getValue(it) }.toIntArray()
    }
}
