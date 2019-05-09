@file:JvmName("Sorts")
package hw

class Sorts {

    //Linear Sort
    companion object {

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
            
        }

        @JvmStatic
        fun main(args:Array<String>) {
            val li1:MutableList<Number> = mutableListOf(3, 4, 1, 2, 5)
            val li2:MutableList<Number> = mutableListOf(5, 2, 1, 4, 3)
            val li3:MutableList<Number> = mutableListOf(3, 5, 9, 7, 1)
//            insertionSort(li1); insertionSort(li2); insertionSort(li3)
//            bubbleSort(li1); bubbleSort(li2); bubbleSort(li3)
//            selectionSort(li1); selectionSort(li2); selectionSort(li3)
            println(li1); println(li2); println(li3)
        }

    }
    
    //TODO: mergeSort, heapSort, quickSort
}
