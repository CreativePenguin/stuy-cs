package hw.platek

class Sorts {
    //Linear Sort

    fun swap(li:MutableList<Number>, i1:Int, i2:Int) {
        val tmp = li[i1]
        li[i1] = i2
        li[i2] = tmp
    }

    fun swap(li:List<Number>, i1:Int, i2:Int):List<Number> {
        var arr = mutableListOf<Number>()
        for(i in li) arr.add(i)
        arr[i1] = li[i2]
        arr[i2] = li[i1]
        return arr
    }

    fun insertionSort(li:MutableList<Number>) {
        for(i in 1..li.size) {
            for(j in i downTo 0) {
                val tmp = li[j]
                li[j] = li[i]
                if(li[i].toDouble() < tmp.toDouble()) {
                    break
                }
            }
        }
    }

    fun main(args:Array<String>?) {
        println(insertionSort(mutableListOf(3, 4, 1, 2, 5)))
        println(insertionSort(mutableListOf(5, 2, 1, 4, 3)))
        println(insertionSort(mutableListOf(3, 5, 9, 7, 1)))
    }

    //TODO:selectionSort, bubbleSort, binarySearch, mergeSort, heapSort, quickSort
}