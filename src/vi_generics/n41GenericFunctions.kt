package vi_generics

import util.TODO
import java.util.*

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

//IL PREDICATO ESTRAE LETTERE (LE singole lettere senza spzione che VANNO IN words , vedi test)
fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
//    task41()
    return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}

fun <T, C : MutableCollection<T>> Collection<T>.partitionTo(first: C, second: C, predicate: (T) -> Boolean): Pair<C,C> {
    for (element in this){
        if ( predicate(element) ){ //il predicato se vale estrae l'elemento del primo array in val (vedi coppia di val nel test chiamante)
            first.add(element)
        }
        else second.add(element)
    }
    return Pair(first,second)
}

//IL PREDICATO ESTRAE LETTERE (LE LETTERE VANNO IN letters , vedi test)
fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
//    task41()
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}