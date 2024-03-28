class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val maxS = park.size - 1
        val maxE = park[0].length - 1
        var site = intArrayOf(0, 0)
        
        //시작점 찾기
        park.forEachIndexed { idxR, row ->
            row.forEachIndexed { idxC, column ->
                if(column == 'S') {
                    site = intArrayOf(idxR, idxC)
                }
            }
        }
        
        //방향 거리 잡기
        routes.forEach {            
            when(it.first()) {
                'E' -> {
                    val tempEW = site[1] + it.last().toInt() - '0'.toInt()
                    
                    if (tempEW > maxE) {
                        println("!!공원을 벗어납니다. 조건을 무시해야합니다.")
                    }                    
                    else {   
                        var moveOrNot = true
                        for (i in site[1] .. maxE) {
                            if (park[site[0]][i] == 'X') {
                                if (tempEW >= i) {
                                    moveOrNot = false
                                }
                            }
                            
                            if (i == maxS && moveOrNot) {
                                site = intArrayOf(site[0], tempEW)
                            }
                        }
                    }
                }
                'W' -> {
                    val tempEW = site[1] - it.last().toInt() + '0'.toInt()
                    
                    if (tempEW < 0) {
                        println("!!공원을 벗어납니다. 조건을 무시해야합니다.")
                    }
                    else {
                        var moveOrNot = true
                        for (i in 0 .. site[1]) {
                            if (park[site[0]][i] == 'X') {
                                if (tempEW <= i) {
                                    moveOrNot = false
                                }
                            }
                            
                            if (i == site[1] && moveOrNot) {
                                site = intArrayOf(site[0], tempEW)
                            }
                        }
                    }
                }
                'S' -> {
                    val tempSN = site[0] + it.last().toInt() - '0'.toInt()
                                        
                    if (tempSN > maxS) {
                        println("!!공원을 벗어납니다. 조건을 무시해야합니다.")
                    } 
                    else {                        
                        var moveOrNot = true
                        for (i in site[0] .. maxS) {
                            if (park[i][site[1]] == 'X') {
                                if (tempSN >= i) {
                                    moveOrNot = false
                                }
                            }
                            
                            if (i == maxS && moveOrNot) {
                                site = intArrayOf(tempSN, site[1])
                            }
                        }
                    }
                    
                }
                'N' -> {
                    val tempSN = site[0] - it.last().toInt() + '0'.toInt()
                    
                    if (tempSN < 0) {
                        println("!!공원을 벗어납니다. 조건을 무시해야합니다.")
                    } 
                    else {
                        var moveOrNot = true
                        for (i in 0 .. site[0]) {
                            if (park[i][site[1]] == 'X') {
                                if (tempSN <= i) {
                                    moveOrNot = false
                                }
                            }
                            
                            if (i == site[0] && moveOrNot) {
                                site = intArrayOf(tempSN, site[1])
                            }
                        }
                    }
                }
            }
        }
                
        return site
    }
}