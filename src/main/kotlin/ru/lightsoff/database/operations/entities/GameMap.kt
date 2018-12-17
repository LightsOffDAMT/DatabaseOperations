package ru.lightsoff.database.operations.entities

import java.util.*

/**
 * GameMap Entity
 */
class GameMap {
    var id: Long? = null
        private set
    var name: String? = null
        private set
    var map: ArrayList<ArrayList<Double>>? = null
        private set

    fun withId(id: Long?): GameMap {
        this.id = id
        return this
    }

    fun withName(name: String): GameMap {
        this.name = name
        return this
    }

    fun withMap(map: ArrayList<ArrayList<Double>>): GameMap {
        this.map = map
        return this
    }
}
