package v_builders

import util.TODO


fun buildStringExample(): String {
    fun buildString(build: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.build()
        return stringBuilder.toString()
    }

    return buildString {
        this.append("Numbers: ")
        for (i in 1..10) {
            // 'this' can be omitted
            append(i)
        }
    }
}

fun todoTask37(): Nothing = TODO(
    """
        Task 37.
        Uncomment the commented code and make it compile.
        Add and implement function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
        building it and returning it as a result.
    """
)
//la funzione come argomento è una function extended per Map, ovvero è un decorator di Map:
//aggiunge una funzione alla classe MutableMap che fa parte dello stdlib di kotlin per cui
//è MutableMap(). -> e non () -> in quanto build poi va chiamato sull'oggetto map
fun <K,V> buildMap(build: MutableMap<K,V>.() -> Unit) : Map<K,V> {
//   val map : Map<K,V> = HashMap()
    val map = HashMap<K,V>()
    map.build()
    return map
}

//primo modo
fun task37(): Map<Int, String> {
    //todoTask37()
    //crea la map ed esegue la funzione sulla mappa restituendola valorizzata
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

//secondo modo lavorando sull'oggetto java HasMap applico del codice Kotlin su esso
//apply è usato al posto di run in quanto deve essere restituito un tipo
fun task37_2() : Map<Int, String>{
    return HashMap<Int,String>().apply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
