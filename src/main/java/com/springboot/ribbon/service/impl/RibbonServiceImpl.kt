package com.springboot.ribbon.service.impl

import com.springboot.ribbon.service.RibbonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class RibbonServiceImpl: RibbonService {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    //@HystrixCommand(fallbackMethod = "errorHandler")
    override fun info(): String? {
        return this.restTemplate.getForObject<String>("http://eureka-client/info", String::class.java)
    }


    override fun errorHandler(): String? {
        return "Server Error"
    }
}
