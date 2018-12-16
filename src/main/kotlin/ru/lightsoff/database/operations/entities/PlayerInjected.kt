package ru.lightsoff.database.operations.entities

import sun.audio.AudioPlayer.player


class PlayerInjected(player: Player): Player(){

    var user: User? = null
        private set

    init {
        this.id = player.id
        this.name = player.name
        this.inventory = player.inventory
        this.position = player.position
        this.stats = player.stats
        this.userID = player.userID
    }
    fun withUser(user: User?): Player{
        this.user = user
        return this
    }
}