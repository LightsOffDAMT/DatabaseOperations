package ru.lightsoff.database.operations.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerMovementController {
    @Value("\${microservices.database.controller}")
    var databaseControllerUrl: String? = null
    @Autowired
    lateinit var userDataController: UserDataController


}