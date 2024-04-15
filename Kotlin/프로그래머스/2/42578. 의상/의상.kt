class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val cMap = HashMap<String, Int>()
        
        for (item in clothes) {
            val itemType = item[1]
            if (cMap.containsKey(itemType)) {
                cMap[itemType] = cMap[itemType]!! + 1
            } else {
                cMap[itemType] = 1
            }
        }
        
        var total = 1
        for (count in cMap.values) {
            total = total * (count + 1)
        }
        
        return total - 1
    }
}