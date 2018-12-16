package ru.lightsoff.database.operations.controllers

import io.micrometer.core.lang.Nullable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import reactor.core.publisher.Mono
import ru.lightsoff.database.operations.entities.GameMap
import ru.lightsoff.database.operations.entities.ItemInGame
import ru.lightsoff.database.operations.entities.ItemInGameInjected

@RestController
class InitializationController {
    @Value("\${microservices.database.controller}")
    var databaseControllerUrl: String? = null
    @Autowired
    lateinit var itemController: ItemController

    class DataPackaged( val map: Array<GameMap>, val items: List<ItemInGameInjected> )

    @RequestMapping("/init")
    fun initialization(@RequestParam @Nullable id: Long?): Mono<DataPackaged>?
        = Mono.just( DataPackaged( getGameMap(id), itemController.getInjectedItemInGame(id) ) )

    fun getGameMap(id: Long?)
        = RestTemplate()
            .getForEntity("$databaseControllerUrl/get/game_map" + if(id!=null)"?id=$id" else "", arrayOf(GameMap()).javaClass  ).body !!

}