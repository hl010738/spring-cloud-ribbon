package com.springboot.ribbon.service

import org.springframework.stereotype.Service


interface RibbonService {

    fun info(): String?

    fun errorHandler(): String?
}
