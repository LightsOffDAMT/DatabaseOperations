package ru.lightsoff.database.operations.entities

class ItemInGameInjected(itemInGame: ItemInGame?): ItemInGame() {
    var item: ItemInStorage? = ItemInStorage()
        private set

    init {
        this.id = itemInGame?.id
        this.itemID = itemInGame?.itemID
        this.position = itemInGame?.position
    }

    fun withItem(item: ItemInStorage?): ItemInGameInjected{
        this.item = item
        return this
    }
}