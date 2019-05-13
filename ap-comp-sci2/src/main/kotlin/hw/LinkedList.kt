package hw

import hw.platek.queue.DNode

class LinkedList<E>:List<E>,Iterator<E>,ListIterator<E> {

    private val header:DNode<E> = DNode<E>(null, null, null)
    private val trailer:DNode<E> = DNode<E>(null,header, null)
    override var size = 0
        private set
    private val first:DNode<E>
        get() {
            return header.next ?: throw IllegalStateException()
        }
    private val last:DNode<E>
        get() {
            return trailer.previous ?: throw IllegalStateException()
        }
    private var current:DNode<E>
    private var counter = 0
    private var removeable = false

    init {
        header.next = trailer
        current = header
    }

    override fun hasNext(): Boolean {
        return current != trailer
    }

    override fun hasPrevious(): Boolean {
        return current != header
    }

    override fun next(): E {
        current = current.next ?: throw NoSuchElementException()
        counter++
        return current.value ?: throw NoSuchElementException()
    }

    override fun previous(): E {
        current = current.previous ?: throw NoSuchElementException()
        counter--
        return current.value ?: throw NoSuchElementException()
    }

    override fun nextIndex(): Int {
        return counter++
    }

    override fun previousIndex(): Int {
        return counter--
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        for(i in elements) {
            if (!contains(i)) return false
        }
        return true
    }

    override fun get(index: Int): E {
        return getNode(index).value ?: throw NoSuchElementException()
    }

    override fun indexOf(element: E): Int {
        var ans = 0
        for(i in this) {
            if(i == element) return ans
            ans++
        }
        return -1
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): Iterator<E> {
        current = header
        return this
    }

    override fun lastIndexOf(element: E): Int {
        var tmp = trailer
        for(i in 0..size) {
            if(element == tmp.value) return i
            tmp = tmp.previous ?: break
        }
        return -1
    }

    override fun listIterator(): ListIterator<E> {
        current = header
        counter = 0
        return this
    }

    override fun listIterator(index: Int): ListIterator<E> {
        current = getNode(index)
        return this
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun contains(element: E): Boolean {
        for(i in this) {
            if(element == i) return true
        }
        return false
    }

    // returns true if v is not the header node
    fun hasPrevious(v: DNode<E>):Boolean {
        return !(v.previous == header)
    }

    // returns true if v is not the trailer node
    fun hasNext(v:DNode<E>):Boolean {
        return !(v.next == trailer)
    }

    // returns the node that comes directly before the current node.
    fun getPrevious(current:DNode<E>):DNode<E> {
        return current.previous ?: throw NoSuchElementException()
    }

    // returns the node that comes directly after the current node.
    fun getNext(current:DNode<E>): DNode<E> {
        return current.next ?: throw NoSuchElementException()
    }

    // inserts node a before node b. 
    // An exception is thrown if b is the header
    fun addBefore(b:DNode<E>, a:DNode<E>) {
        b.previous?.next = a
        a.previous = b.previous
        b.previous = a
        a.next = b
        size++
    }

    fun addBefore(b:DNode<E>, value:E) {
        val ans = DNode<E>(value, b.previous, b)
        b.previous?.next = ans
        b.next?.previous = ans
    }

    fun addLast(node:DNode<E>) {
        addBefore(trailer, node)
        size++
    }

    fun addLast(value:E) {
        addBefore(trailer, value)
        size++
    }

    // inserts node b after node a
    // throw exception if a is the trailer node
    fun addAfter(a:DNode<E>, b:DNode<E>) {
        addBefore(a.next, b)
        size++
    }

    fun addFirst(current:DNode<E>) {
        addAfter(header, current)
        size++
    }

    fun addFirst(value:E) {
        header.next?.previous = header.next
        header.next = DNode<E>(value, header, header.next)
        size++
    }

    //precondition: v != null and is a node in the list
    //postconditon: removes the node v refers to.
    //              Throws exception if v is header or trailer.
    fun remove(v:DNode<E>) {
        v.next?.previous = v.previous
        v.previous.setNext(v.getNext())
        size--
    }

    fun remove(v:E):E {
        val current = getNode(v)
        val ans = current.getValue()
        remove(current)
        return ans
    }

    fun removeFirst():E {
        val tmp = first.getValue()
        remove(first)
        size--
        return tmp
    }

    fun removeLast():E {
        val tmp = last.getValue()
        remove(last)
        size--
        return tmp
    }

    fun getNode(i:Int):DNode<E> {
        if(i < 0 || i > size) throw IndexOutOfBoundsException()
        var selected = if(i < size / 2) first else last
        if(i < size / 2) {
            for(j in 0 until size) {
                if(j == i) return selected
                selected = selected.getNext()
            }
        }
        else {
            for(j in size downTo 0) {
                if(j == i) return selected
                selected = selected.getNext()
            }
        }
        throw RuntimeException("panic")
    }

    fun getNode(v:E):DNode<E> {
        for(i in this) {
            if(i == v) return current
        }
        throw NoSuchElementException()
    }

    fun swap(x:DNode<E>, y:DNode<E>) {
        if(!hasNext(x) || !hasNext(y) || !hasPrevious(x) || !hasPrevious(y)) return
        if(x == y) return
        if(getPrevious(x) == y) {
            swap(y, x)
            return
        }
        val dummy = DNode<E>(null, null, null)
        addAfter(x, dummy)
        x.setNext(getNext(y))
        x.setPrevious(getPrevious(y))
        y.setNext(getNext(x))
        y.setPrevious(getPrevious(x))
        getPrevious(x).setNext(y)
        getNext(x).setPrevious(y)
        getPrevious(y).setNext(x)
        getNext(x).setPrevious(x)
        remove(dummy)
    }

    fun addAll(l:LinkedList<E>) {
        for(i in l) {
            l.addLast(i)
        }
    }

    override fun toString():String {
        var ans = ""
        var current = header.next
        while (current != trailer){
            ans += current.getValue().toString() + ", "
            current = current.next
        }
        val len = ans.length
        if (len > 0) ans = ans.substring(0,len - 2)
        ans = "[" + ans + " ]"
        return ans
    }

    fun main() {
        val L = LinkedList<Int>()

        System.out.println("L : " + L)
        for(i in 0..10) {
            L.addFirst(i)
            System.out.println("add " + i + " : " + L)
       	}
    }

}
