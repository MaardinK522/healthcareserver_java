package com.mkproductions.healthcareserver.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    @RequestMapping(value = ["/"])
    fun sayHello(): String {
        return "<center>Hello! World</center>"
    }
}