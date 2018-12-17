package ru.lightsoff.database.operations.entities

import java.awt.Point
import java.util.*

/**
 * Player entity
 */
open class Player {
    var id: Long? = null

    var name: String? = null

    var inventory: ArrayList<ArrayList<Int>>? = null

    var stats: ArrayList<Int>? = null

    var userID: Long? = null

    var position: Point? = null


    fun withId(id: Long): Player {
        this.id = id
        return this
    }

    fun withName(name: String): Player {
        this.name = name
        return this
    }


    fun withUserID(userID: Long): Player {
        this.userID = userID
        return this
    }

    fun withInventory(inventory: ArrayList<ArrayList<Int>>): Player {
        this.inventory = inventory
        return this
    }

    fun withStats(stats: ArrayList<Int>): Player {
        this.stats = stats
        return this
    }

    fun withPosition(position: Point): Player {
        this.position = position
        return this
    }
}
