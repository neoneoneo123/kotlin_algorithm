class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        // 각 의상 종류별 개수를 세기 위한 HashMap
        val clothesMap = HashMap<String, Int>()

        // clothes 배열을 순회하면서 각 의상 종류의 개수 세기
        for (item in clothes) {
            val itemType = item[1] // 의상 종류
            if (clothesMap.containsKey(itemType)) {
                clothesMap[itemType] = clothesMap[itemType]!! + 1
            } else {
                clothesMap[itemType] = 1
            }
        }

        // 가능한 조합의 수 계산
        var totalCombinations = 1
        for (count in clothesMap.values) {
            totalCombinations *= (count + 1) // 각 의상 종류에서 선택하지 않는 경우를 포함하여 계산
        }

        // 모든 의상을 선택하지 않는 경우 1가지를 빼고 반환
        return totalCombinations - 1
    }
}