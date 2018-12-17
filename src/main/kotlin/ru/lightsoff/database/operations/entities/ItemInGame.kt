package ru.lightsoff.database.operations.entities

import java.awt.Point

/**
 * ItemInGame entity
 */
open class ItemInGame {
    var id: Long? = null

    var itemID: Long? = null

    var position: Point? = null


    fun withId(id: Long?): ItemInGame {
        this.id = id
        return this
    }

    fun withPosition(position: Point): ItemInGame {
        this.position = position
        return this
    }

    fun withItemId(id: Long?): ItemInGame {
        this.itemID = id
        return this
    }


}
