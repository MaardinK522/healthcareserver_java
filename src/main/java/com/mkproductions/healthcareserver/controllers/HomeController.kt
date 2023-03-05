package com.mkproductions.healthcareserver.controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {
    @Value("\${server_addres}")
    private lateinit var serverAddress: String

    @GetMapping()
    fun homePage(): String {
        return "Index"
    }
}