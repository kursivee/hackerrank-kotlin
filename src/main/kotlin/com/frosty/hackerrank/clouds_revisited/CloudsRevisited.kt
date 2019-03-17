package com.frosty.hackerrank.clouds_revisited

class CloudsRevisited {
    var energy: Int = 100
    fun jumpingOnClouds(c: Array<Int>, k: Int): Int {
        var end = false
        var i = 0
        while(!end) {
            i = (i + k) % c.size
            val cloud = c[i]
            println("CLOUD: $cloud, index: $i, energy: $energy")
            energy--
            if(cloud == 1) {
                energy -= 2
            }
            if(i == 0)
                end = true
        }
        return energy
    }
}