package com.mkproductions.healthcareserver.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(value = ["/docs"])
class DocumentController {
    @GetMapping
    fun returnDocPage(): String {
        return "Documentation"
    }
}