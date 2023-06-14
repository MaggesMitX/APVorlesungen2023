package outList

interface OurListInterface {

    fun printAllElements()
    fun addFirst(element : Any)
    fun addLast(element : Any)
    fun contains(element : Any) : Boolean
    fun isEmpty() : Boolean
    fun get(index : Int) : Any?
    fun remove(element : Any)
  //  fun getSize() : Int
    val size : Int
    val last : Any?
    val first: Any
}

fun main() {

    val i = 0
    val myList = ListByDelegation()

    if (i == 0) {
        do {
            print("List add")
            val input = readLine()
            if (input == "Add") {


                if (input == "All") {
                    myList.printAllElements()
                }
                if (input == "Last") {
                    print(myList.last)
                }
            } else

                when (input) {
                    "All" -> myList.printAllElements()
                    "Last" -> println (myList.last)
                    "First" -> println (myList.first)
                    "add" -> {
                        print("Neuer Eintrag")
                        val newEntry = readln()
                        if (myList != null) {
                            myList.addLast(newEntry)
                        } else {
                            print("Falsche Eingabe")
                        }
                    }
                }

        } while (input != "End") }
}
