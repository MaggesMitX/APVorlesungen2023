 class Song(val title : String,val artist : String, val duration : Int) {

}

abstract class Tree(){

}
object EmptySong : Tree() {
}
class SongNode(val Song : Song, val left : Tree = EmptySong, val right : Tree = EmptySong) : Tree()
fun main() {
    val Bohemian = Song("Bohemian", "Queen", 359)
    val Holiday = Song("Holiday", "Green Day", 235)
    val MasterOfPuppets = Song("Mater of Puppets", "Metallica", 515)
    val Africa = Song("Afica", "Toto", 2950)
    val Tennager = Song("Tennager", "MyChemicalRomance", 172)
    val Flasko = Song("Flasko", "Die Ärtze", 164)

    val MasterOfPuppetsTree = SongNode(MasterOfPuppets)
    val AfricaTree = SongNode(Africa)
    val TreeHoliday = SongNode(Holiday, MasterOfPuppetsTree, AfricaTree)

}

