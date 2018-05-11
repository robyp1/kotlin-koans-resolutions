package iv_properties

import util.TODO

class LazyProperty(val initializer: () -> Int) { //funzione come parametro
    private val lazyValue : Int? = null
        get(){
            if (field == null){
                field = initializer()
            }
            return field
        }
    val lazy: Int //todoTask33()
        get() = lazyValue!! //double bang perchè altrimenti non può convertire Int? (nullabile) in Int (non nullo),
                            //se null deve lanciare una NPE (null pointer exception) per forza
}

fun todoTask33(): Nothing = TODO(
    """
        Task 33.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegated properties yet!
    """,
    references = { LazyProperty({ 42 }).lazy }
)
