package trees

class Person(val Name : String, val  Nachname : String, val Alter : Int, val groesse : Int)
class Student(Name: String, Nachname: String, Alter: Int, Groesse: Int)

sealed class Tree () {
    abstract fun ausgabe() : Unit
    abstract fun size() : Int
    abstract fun foreach( task : (Person) -> Unit)

}
/*
abstract class Tree() {
    abstract fun ausgabe() : Unit

    abstract  fun size() : Int

}*/


class TreeNode (val person : Person, val left : Tree = EmptyTree, val right : Tree = EmptyTree) : Tree() {
    override fun ausgabe() {
        println("Die nächste Person ist $person")

        //println(person) Pre Order
        left.ausgabe()
        println(person) //In Order
        right.ausgabe()
        //println(person) Post Order

    }

    override fun size() : Int = left.size() + right.size() +1
    override fun foreach(task: (Person) -> Unit) {
        task(this.person)
    }

}
object EmptyTree : Tree() {

    override fun size(): Int {
        return 0
    }

    override fun foreach(task: (Person) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun ausgabe() {
        println("leerer Baum")
    }
}

fun demoTree() {
        val susi = Person("Susi", "Sonnenschein", 17, 172)
        val lars = Person("Lars", "Lustig", 22, 189)
        val hanna = Person("Hanna", "Heiter", 19, 162)
        val horst = Person("Horst", "Puschalke", 21, 175)
        val karla = Person("Karla", "Kolumna", 20, 155)

    val tree = TreeNode(karla,
            TreeNode(susi,
            TreeNode(lars),
            TreeNode(horst)),
            TreeNode(hanna))

    val treeLars = TreeNode(lars)
    val treeHorst = TreeNode(horst)
    val treeSusi = TreeNode(susi, treeLars, treeHorst)
    val treeHanna =  TreeNode(hanna)
    val treeKarla =  TreeNode(karla, treeSusi, treeHanna)

    treeKarla.ausgabe()
    treeKarla.foreach { println("Person: ${it.Name}") }


    fun ausgabeBaum(t : Tree) {
        t.ausgabe()
    }
    ausgabeBaum(treeLars.left)

    val tree_ = EmptyTree

    val bspTree = TreeNode(lars, EmptyTree, EmptyTree)

}