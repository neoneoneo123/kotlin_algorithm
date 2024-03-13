class Solution {
    fun solution(numbers: IntArray): IntArray {
        var mySet = mutableSetOf<Int>()

        for (i in 0 .. numbers.size - 1) {
            for (j in i + 1 .. numbers.size - 1) {
                val temp = numbers[i] + numbers[j]
                mySet.add(temp)
            }
        }
        
        return mySet.sorted().toIntArray()
    }
}