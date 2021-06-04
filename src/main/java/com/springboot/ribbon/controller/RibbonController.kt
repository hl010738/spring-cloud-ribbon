package com.springboot.ribbon.controller

import com.springboot.ribbon.service.RibbonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RibbonController {

    @Autowired
    private lateinit var ribbonService: RibbonService

    @Autowired
    private lateinit var loadBalancerClient: LoadBalancerClient

    @GetMapping("/info")
    fun info(): String? {
        return ribbonService.info()
    }

    @GetMapping("/serviceInfo")
    fun serviceInfo(): String? {
        val serviceInstance = loadBalancerClient.choose("eureka-client")
        return "port: ${serviceInstance.port}"
    }
}
