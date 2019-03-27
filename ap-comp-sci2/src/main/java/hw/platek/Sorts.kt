@file:JvmName("Sorts")
package hw.platek

class Sorts {

    //Linear Sort
    companion object {

        fun swap(li:MutableList<Number>, i1:Int, i2:Int) {
            val tmp = li[i1]
            li[i1] = li[i2]
            li[i2] = tmp
        }

        fun swap(li:List<Number>, i1:Int, i2:Int):List<Number> {
            val arr = mutableListOf<Number>()
            for(i in li) arr.add(i)
            arr[i1] = li[i2]
            arr[i2] = li[i1]
            return arr
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

        

        @JvmStatic
        fun main(args:Array<String>) {
            var li1:MutableList<Number> = mutableListOf(3, 4, 1, 2, 5)
            var li2:MutableList<Number> = mutableListOf(5, 2, 1, 4, 3)
            var li3:MutableList<Number> = mutableListOf(3, 5, 9, 7, 1)
            insertionSort(li1); insertionSort(li2); insertionSort(li3)
            println(li1); println(li2); println(li3)
        }

    }
    
    //TODO:selectionSort, bubbleSort, binarySearch, mergeSort, heapSort, quickSort
}