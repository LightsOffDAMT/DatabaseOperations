package ru.lightsoff.database.operations

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
@EnableDiscoveryClient
class Application
//TODO Add R-tree to make fast data queries
fun main(args: Array<String>) {
	runApplication<Application>(*args)
}

