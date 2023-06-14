package outList

import java.util.NoSuchElementException

class ourLinkedList : OurListInterface  {

    class Node (
        val dataElement : Any,
        var nextElement : Node?
        )

    var firstNode : Node? = null
    override fun printAllElements() {
        var runpointer = firstNode

        while (runpointer != null) {
            println(runpointer.dataElement)
            runpointer = runpointer.nextElement
        }
    }


    override fun addFirst(element: Any) {
        //val newEntry =  Node(element , firstNode)
        //firstNode = newEntry
        //oder/ geht beides
        firstNode = Node(element, firstNode)
    }

    override fun addLast(element: Any) {

        if (isEmpty()) {
            addFirst(element)
        } else {
            var runpointer = firstNode
            while (runpointer?.nextElement != null) {

                runpointer = runpointer.nextElement
            }
            runpointer?.nextElement = Node(element, null)
        }
    }

    override fun contains(element: Any): Boolean{
        var counter = 0
        var runPointer = firstNode
        while (runPointer != null) {
            if (runPointer.nextElement == element) {
                return true
            }
            runPointer = runPointer.nextElement
        }
        return false
    }


    override fun isEmpty(): Boolean = firstNode  == null

    override fun get(index: Int): Any? {
        var count  = 0
        var runPointer = firstNode
        while (runPointer != null){
            if (count == index) {
                return runPointer.dataElement
            }
            count++
            runPointer = runPointer.nextElement
        }
        return null
    }

    override fun remove(element: Any) {
        val runPointer = firstNode
        if (firstNode?.dataElement == element) {
            firstNode= firstNode?.nextElement
        }
        while (runPointer != null) {
            if (runPointer.nextElement?.dataElement == element) {
                runPointer.nextElement = runPointer.nextElement?.nextElement
            }
        }
    }

    override val size: Int
        get() {
            var count = 0
            var runPointer = firstNode
            while (runPointer != null) {
                count ++
                runPointer = runPointer.nextElement
            }
            return count
        }
    override val last: Any?
        get() {
            var runPointer = firstNode
            while (runPointer?.nextElement != null) {
                runPointer = runPointer.nextElement
            }
            return runPointer?.dataElement
        }
    override val first: Any
        get() = firstNode?.dataElement ?: throw NoSuchElementException()

}