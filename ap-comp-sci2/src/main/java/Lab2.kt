package src.main.java

class SortStats {
    
    fun bubbleSort(list:MutableList<Int>) {
        var counter = 0
        do {
            if(list[counter] > list[counter + 1]) 
                swap(list, counter, counter + 1)
        } while (counter < list.size - 1)
    }

    fun bubbleShort(list:MutableList<Int>) {
        var counter = 0
        do {
            if

    private fun swap(list:MutableList<Int>, i1:Int, i2:Int) {
        val tmp = list[i1]
        list[i1] = list[i2]
        list[i2] = tmp
    }
    
    fun main() {

    }
