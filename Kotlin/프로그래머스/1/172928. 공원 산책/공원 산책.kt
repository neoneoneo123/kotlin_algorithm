class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()        
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
        
        println("시작점은? :: [${site[0]}, ${site[1]}]")

        //방향 거리 잡기
        routes.forEach {            
            when(it.first()) {
                'E' -> {
                    println("--> 현재 내가 있는 칸은? :: [${site[0]}, ${site[1]}]")
                    println("E 방향으로 ${it.last()}칸 이동해야합니다.")
                    val tempEW = site[1] + it.last().toInt() - '0'.toInt()
                    
                    //공원을 벗어나는지 확인
                    if (tempEW > maxE) {
                        println("!!공원을 벗어납니다. 조건을 무시해야합니다.")
                    }
                    
                    //장애물을 만나는지 확인
                    else {   
                        println("--> ${site[1]}번째 열을 검사해야함")
                        
                        var moveOrNot = true
                        for (i in site[1] .. maxE) {
                            println("--> ${i}번째 열의 ${site[0]}번째 칸이 과연 X일까? :: ${park[0][i]}")
                            if (park[site[0]][i] == 'X') {
                                println("---> X를 찾았습니다.")

                                if (tempEW >= i) {
                                    println("---> 이동해야 하는 칸 수인 ${tempEW}보다 X가 있는 위치인 ${i}가 작으니 X를 지나쳐야하네요. 조건을 무시해야합니다.")
                                    moveOrNot = false
                                } else if (tempEW <= i) {
                                    println("---> 이동해야 하는 칸 수인 ${tempEW}보다 X가 있는 위치인 ${i}가 크니 X를 지나치지 않아도 되네요. 무시하지 않아도 됩니다.")
                                }
                            }
                            
                            if (i == maxS && moveOrNot) {
                                println("--> 모든 요소를 다 찾아보았지만 X가 없거나 X를 지나치지 않습니다.")
                                site = intArrayOf(site[0], tempEW)
                                println("이동한 칸은 [${site[0]}, ${tempEW}] 입니다.")
                            }
                        }
                    }
                }
                'W' -> {
                    println("W 방향으로 ${it.last()}칸 이동해야합니다.")
                    val tempEW = site[1] - it.last().toInt() + '0'.toInt()
                    
                    //공원을 벗어나는지 확인
                    if (tempEW < 0) {
                        println("!!공원을 벗어납니다. 조건을 무시해야합니다.")
                    }
                    
                    //장애물을 만나는지 확인
                    else {
                        
                        println("--> ${site[1]}번째 열을 검사해야함")
                        
                        var moveOrNot = true
                        for (i in 0 .. site[1]) {
                            println("--> ${i}번째 열의 ${site[0]}번째 칸이 과연 X일까? :: ${park[0][i]}")
                            if (park[site[0]][i] == 'X') {
                                println("---> X를 찾았습니다.")

                                if (tempEW <= i) {
                                    println("---> 현재 이동해야 하는 칸 수인 ${tempEW}보다 ${i}가 작아 X를 지나쳐야하네요. 조건을 무시해야합니다.")
                                    moveOrNot = false
                                }
                            }
                            
                            if (i == site[1] && moveOrNot) {
                                println("--> 모든 요소를 다 찾아보았지만 X가 없거나 X를 지나치지 않습니다.")
                                site = intArrayOf(site[0], tempEW)
                                println("이동한 칸은 [${site[0]}, ${tempEW}] 입니다.")
                            }
                        }
                    }
                }
                'S' -> {
                    println("S 방향으로 ${it.last()}칸 이동해야합니다.")
                    val tempSN = site[0] + it.last().toInt() - '0'.toInt()
                    println("--> 현재 내가 있는 칸은? :: [${site[0]}, ${site[1]}]")
                                        
                    //공원을 벗어나는지 확인
                    if (tempSN > maxS) {
                        println("!!공원을 벗어납니다. 조건을 무시해야합니다.")
                    } 
                    //장애물을 만나는지 확인
                    else {
                        
                        println("--> ${site[1]}번째 열을 검사해야함")
                        
                        var moveOrNot = true
                        for (i in site[0] .. maxS) {
                            println("--> ${i}번째 행의 ${site[1]}번째 칸이 과연 X일까? :: ${park[i][1]}")
                            if (park[i][site[1]] == 'X') {
                                println("---> X를 찾았습니다.")

                                if (tempSN >= i) {
                                    println("---> 현재 이동해야 하는 칸 수인 ${tempSN}보다 ${i}가 작아 X를 지나쳐야하네요. 조건을 무시해야합니다.")
                                    moveOrNot = false
                                }
                            }
                            
                            if (i == maxS && moveOrNot) {
                                println("--> 모든 요소를 다 찾아보았지만 X가 없거나 X를 지나치지 않습니다.")
                                site = intArrayOf(tempSN, site[1])
                                println("이동한 칸은 [${tempSN}, ${site[1]}] 입니다.")
                            }
                        }
                    }
                    
                }
                'N' -> {
                    println("N 방향으로 ${it.last()}칸 이동해야합니다.")
                    val tempSN = site[0] - it.last().toInt() + '0'.toInt()
                    println("--> 현재 내가 있는 칸은? :: [${site[0]}, ${site[1]}]")
                    
                    //공원을 벗어나는지 확인
                    if (tempSN < 0) {
                        println("!!공원을 벗어납니다. 조건을 무시해야합니다.")
                    } 
                    //장애물을 만나는지 확인
                    else {
                        
                        println("--> ${site[1]}번째 열을 검사해야함")
                        
                        var moveOrNot = true
                        for (i in 0 .. site[0]) {
                            println("--> ${i}번째 행의 ${site[1]}번째 칸이 과연 X일까? :: ${park[i][1]}")
                            if (park[i][site[1]] == 'X') {
                                println("---> X를 찾았습니다.")

                                if (tempSN <= i) {
                                    println("---> 현재 이동해야 하는 칸 수인 ${tempSN}보다 ${i}가 커 X를 지나쳐야하네요. 조건을 무시해야합니다.")
                                    moveOrNot = false
                                }
                            }
                            
                            if (i == site[0] && moveOrNot) {
                                println("--> 모든 요소를 다 찾아보았지만 X가 없거나 X를 지나치지 않습니다.")
                                println("이동한 칸은 [${tempSN}, ${site[1]}] 입니다.")
                                site = intArrayOf(tempSN, site[1])
                            }
                        }
                    }
                }
            }
        }
        
        answer = site
        
        return answer
    }
}