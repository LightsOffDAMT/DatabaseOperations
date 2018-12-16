package ru.lightsoff.database.operations.controllers

import io.micrometer.core.lang.Nullable
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import reactor.core.publisher.Mono
import ru.lightsoff.database.operations.entities.ItemInGame
import ru.lightsoff.database.operations.entities.ItemInGameInjected
import ru.lightsoff.database.operations.entities.ItemInStorage
import sun.plugin2.main.client.MessagePassingOneWayJSObject

@RestController
class ItemController {
    @Value("\${microservices.database.controller}")
    var databaseControllerUrl: String? = null

    @RequestMapping("/injected/itemInGame")
    fun injectedItemInGameController(@RequestParam @Nullable id: Long?)
            = Mono.just( getInjectedItemInGame(id) )

    fun getInjectedItemInGame(id: Long?)
            = RestTemplate()
                .getForEntity("$databaseControllerUrl/get/item_in_game" + if(id!=null)"?id=$id" else "", arrayOf(ItemInGame()).javaClass  ).body !!
            .map { itemInGame -> ItemInGameInjected(itemInGame).withItem(getItemInStorageData(itemInGame.itemID)?.get(0)) }

    private fun getItemInStorageData(id: Long? )
            = RestTemplate()
            .getForEntity("$databaseControllerUrl/get/item_in_storage" + if(id!=null)"?id=$id" else "", arrayOf(ItemInStorage()).javaClass ).body !!

}