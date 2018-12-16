package ru.lightsoff.database.operations.controllers

import com.netflix.discovery.DiscoveryClient
import com.netflix.discovery.EurekaClient
import com.netflix.niws.client.http.RestClient
import io.micrometer.core.lang.Nullable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import reactor.core.publisher.Mono
import ru.lightsoff.database.operations.entities.Player
import ru.lightsoff.database.operations.entities.PlayerInjected
import ru.lightsoff.database.operations.entities.User
import javax.print.attribute.standard.JobOriginatingUserName

@RestController
class UserDataController {
    @Value("\${microservices.database.controller}")
    var databaseControllerUrl: String? = null

    @RequestMapping("/injected/player")
    fun injectedPlayerController(@RequestParam @Nullable id: Long?)
        = Mono.just( getInjectedPlayer(id) )

    fun getInjectedPlayer(@Nullable id: Long?)
            = RestTemplate()
                .getForEntity("$databaseControllerUrl/get/player" + if(id!=null)"?id=$id" else "", arrayOf(Player()).javaClass  ).body !!
                .map { player -> PlayerInjected(player).withUser(getUserData(player.userID)?.get(0)) }

    private fun getUserData(id: Long? )
            = RestTemplate()
                        .getForEntity("$databaseControllerUrl/get/user" + if(id!=null)"?id=$id" else "", arrayOf(User()).javaClass ).body

}