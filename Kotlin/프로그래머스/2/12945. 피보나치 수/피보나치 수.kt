class Solution {
    fun solution(n: Int): Int {             
        var tempList = mutableListOf<Long>()
        for (i in 0 .. n) {           
            when(i) {
                0 -> tempList.add(0)
                1 -> tempList.add(1)
                else -> {
                    tempList.add( (tempList[i - 1] % 1234567L) + (tempList[i - 2] % 1234567L) )
                }
            }           
        }
        return (tempList.last() % 1234567L).toInt()
    }
}