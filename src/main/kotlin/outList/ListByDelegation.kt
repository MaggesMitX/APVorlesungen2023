package outList

class ListByDelegation : OurListInterface {

    private val data = mutableListOf<Any>()


    override fun addFirst(element: Any) {
        data.add(0, element)
    }

    override fun addLast(element: Any) {
        data.add(element)
    }

    override fun contains(element: Any): Boolean {
        return data.contains(element)
    }

    override fun isEmpty(): Boolean {
        return data.isEmpty()
    }

    override fun get(index: Int): Any {
        return data.get(index)
    }

    override fun remove(element: Any) {
        data.remove(element)
    }



    override val first: Any
        get() = data.first()
    override val last: Any
        get() = data.last()
    override val size: Int
        get() = data.size

    override fun printAllElements() {
        for (i in data) {
            print(i)
        }
    }
}

