package finalproject.util

object Sorts {

    //Linear Sort
    fun swap(li:MutableList<Number>, i1:Int, i2:Int) {
        val tmp = li[i1]
        li[i1] = li[i2]
        li[i2] = tmp
    }

    fun insertionSort(li:MutableList<Number>) {
        for(i in 1 until li.size - 1) {
            for(j in i - 1 downTo 0) {
                if(li[j].toDouble() < li[j + 1].toDouble()) {
                    break
                }
                swap(li, j + 1, j)
           }
        }
    }

    fun bubbleSort(li:MutableList<Number>) {
        var isSorted = false
        while(!isSorted) {
            isSorted = true
            for(i in 0 until li.size - 2) {
                if(li[i].toDouble() > li[i + 1].toDouble()) {
                    swap(li, i, i + 1)
                    isSorted = false
                }
            }
        }
    }

    fun selectionSort(li:MutableList<Number>) {
        for(i in 0 until li.size) {
            var minVal = i
            for(j in i until li.size) {
                if(li[j].toDouble() < li[minVal].toDouble()) minVal = j
            }
            swap(li, minVal, i)
        }
    }

    fun quickSort(li:MutableList<Number>) {
        quickSortH(li, 0, li.size - 1)
    }

    private fun quickSortH(li: MutableList<Number>, low:Int, high:Int) {
        if(low < high) {
            val pi = partition(li, low, high)

            quickSortH(li, low, pi - 1)
            quickSortH(li, pi + 1, high)
        }
    }

    private fun partition(li: MutableList<Number>, low:Int, high:Int):Int {
        val pivot = li[high]
//        println("pivot: $li $pivot")
        var i = low - 1
        for(j in low until high) {
            if (li[j].toDouble() <= pivot.toDouble()) {
//                println("swap: $li ${li[j]} & ${li[i + 1]} bc ${li[j]} <= $pivot")
                swap(li, j, ++i)
            }
        }
        swap(li, high, ++i)
        return i
    }
    
    fun binaryTree(li:MutableList<Number>):MutableList<Number> {
        for(i in li.size..1) {
            val parent = getParentIndex(i)
            if(i % 2 == 0) if(li[i].toDouble() < li[parent].toDouble()) swap(li, i, parent)
            else if(li[i].toDouble() > li[parent].toDouble()) swap(li, i, parent)
        }
        return li
    }
    
    private fun getParentIndex(index:Int):Int {
        return (Math.ceil(index / 2.0) - 1).toInt()
    }

    @JvmStatic
    fun <T: Comparable<T>> mergeSort(li:MutableList<T>) {
        mergeSort(li, 0, li.size)
    }

    private fun <T:Comparable<T>> mergeSort(li:MutableList<T>, l:Int, r:Int) {
        val m = (l + r) / 2
            if (l < r && l != m && r != m) {
            println("li:$li    l:$l,m:$m,r:$r")
            mergeSort(li, l, m)
            mergeSort(li, m, r)
            merge(li, l, m, r)
        }
    }

    private fun <T:Comparable<T>> merge(li:MutableList<T>, l:Int, m:Int, r:Int) {
        val L = mutableListOf<T>()
        for(i in li.subList(l, m)) L.add(i)
        val R = mutableListOf<T>()
        for(i in li.subList(m, r)) R.add(i)
        var i = 0; var j = 0; var k = l
        while(i < L.size && j < R.size) {
            if (L[i] < R[j]) {
                li[k++] = L[i++]
            } else {
                li[k++] = R[j++]
            }
        }
        while(i < L.size) li[k++] = L[i++]
        while(j < R.size) li[k++] = R[j++]
    }

    @JvmStatic
    fun main(args:Array<String>) {
        val li1:MutableList<Int> = mutableListOf(3, 4, 1, 2, 5)
        val li2:MutableList<Int> = mutableListOf(5, 2, 1, 4, 3, 7, 6)
        val li3:MutableList<Int> = mutableListOf(3, 5, 9, 7, 1)
//        insertionSort(li1); insertionSort(li2); insertionSort(li3)
//        bubbleSort(li1); bubbleSort(li2); bubbleSort(li3)
//        selectionSort(li1); selectionSort(li2); selectionSort(li3)
//        quickSort(li1); quickSort(li2); quickSort(li3)
        mergeSort(li1); mergeSort(li2); mergeSort(li3)
        println(li1); println(li2); println(li3)
    }

}

//TODO: heapSort

