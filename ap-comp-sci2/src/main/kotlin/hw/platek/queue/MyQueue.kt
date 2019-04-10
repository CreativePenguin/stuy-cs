package hw.platek.queue

interface MyQueue<E> {
    //Note: There are no checked exceptions in kotlin
    fun add(n:E):Boolean
    fun remove():E
//    fun size():Int
//    fun isEmpty():Boolean
    fun peek():E
}

class ArrayQueue<E>(private val cap:Int):MyQueue<E> {
    private var queue:MutableList<E> = mutableListOf<E>()
    var size = 0
    val isEmpty
        get() = size == 0

    override fun add(n:E):Boolean {
        if(size == cap) throw IllegalStateException()
        queue[++size] = n
        return true
    }

    override fun remove():E {
        val tmp = queue[0]
        queue = queue.subList(1, queue.size)
        size--
        return tmp
    }
    
    override fun peek():E {
        return queue[0]
    }

}

class NodeQueue<E>():MyQueue<E> {
    var head:Node<E>? = null
    var tail:Node<E>? = null
    var size = 0 
        private set
    val isEmpty
        get() = size == 0

    override fun add(n:E):Boolean {
        tail!!.next = Node<E>(n, null)
        tail = tail!!.next
        size++
        return true
    }

    override fun peek():E {
        if(isEmpty) throw NoSuchElementException()
        return head!!.value
    }

    override fun remove():E {
        if(isEmpty) throw NoSuchElementException()
        val ans = head
        head = head?.next
        size--
        return ans!!.value
    }

}

class Node<E>(val value:E, var next:Node<E>?){

}
