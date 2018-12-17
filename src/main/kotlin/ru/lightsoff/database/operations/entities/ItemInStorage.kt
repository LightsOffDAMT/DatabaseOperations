package ru.lightsoff.database.operations.entities

import java.util.*

/**
 * ItemInStorage entity
 */
class ItemInStorage {
    var id: Long? = null
        private set
    var name: String? = null
        private set
    var properties = HashMap<String, String>()
        private set

    fun withId(id: Long?): ItemInStorage {
        this.id = id
        return this
    }

    fun withName(name: String): ItemInStorage {
        this.name = name
        return this
    }

    fun withProperties(properties: HashMap<String, String>): ItemInStorage {
        this.properties = properties
        return this
    }

    fun withProperty(key: String, value: String): ItemInStorage {
        Optional.of(properties).orElseThrow(::Exception)[key] = value
        return this
    }
}
