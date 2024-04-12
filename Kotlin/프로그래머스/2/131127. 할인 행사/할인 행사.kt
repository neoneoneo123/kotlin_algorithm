class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        var amount = number.sum()
        var itemMap = mutableMapOf<String, Int>()
        
        want.forEachIndexed { idx, item -> //map 형태로 사야할 것과 개수를 저장해둠
            itemMap[item] = number[idx]
        }
        
        for (i in 0 .. discount.size - amount) { //최대 number 합계 수 만큼 사야하므로 세일 상품 목록 중 살 수 있는 개수 만큼만 반복
            val listMap = itemMap.toMutableMap() //사야할 것 목록
            
            for (j in 0 until amount) { //목록을 순회하면서
                if (listMap.containsKey(discount[i + j])) { //목록 map 안에 살 수 있는 물건이 있으면
                    listMap[discount[i + j]] = listMap[discount[i + j]]?.minus(1) ?: -1  //해당 물건을 산다고 가정하고 1을 뺀 값을 다시 넣어줌
                }
            }

            if (listMap.all { it.value === 0 }) answer++ //맵의 모든 value 값이 0이면 모든 물건을 다 살 수 있는 것으로 answer 증가
        }
        
        return answer
    }
}