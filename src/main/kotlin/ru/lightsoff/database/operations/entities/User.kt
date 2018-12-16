package ru.lightsoff.database.operations.entities

/**
 * User entity
 */
class User {
    var id: Long? = null
        private set
    var login: String? = null
        private set
    var password: String? = null
        private set
    var email: String? = null
        private set
    var nickname: String? = null
        private set
    var online: Boolean? = null
        private set // mb isOnline?

    fun withId(id: Long?): User {
        this.id = id
        return this
    }

    fun withLogin(login: String): User {
        this.login = login
        return this
    }

    fun withPassword(password: String): User {
        this.password = password
        return this
    }

    fun withEmail(email: String): User {
        this.email = email
        return this
    }

    fun withNickname(nickname: String): User {
        this.nickname = nickname
        return this
    }

    fun online(online: Boolean?): User {
        this.online = online
        return this
    }
}
