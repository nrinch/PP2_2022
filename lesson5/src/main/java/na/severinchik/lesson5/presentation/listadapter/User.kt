package na.severinchik.lesson5.presentation.listadapter

import na.severinchik.lesson5.presentation.basic.BasicUiEntity

data class User(
    val name: String,
    val surname: String,
) : BasicUiEntity<User>() {
    var id: Int = 0

    constructor(
        id: Int, name: String,
        surname: String
    ) : this(name, surname) {
        this.id = id
    }

    override fun same(entity: BasicUiEntity<User>): Boolean {
        return entity is User && entity.id == id
    }

    override fun contentSame(entity: BasicUiEntity<User>): Boolean {
        return entity is User && entity == this
    }
}