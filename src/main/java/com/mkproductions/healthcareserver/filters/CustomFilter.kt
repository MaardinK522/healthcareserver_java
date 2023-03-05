package com.mkproductions.healthcareserver.filters

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.springframework.stereotype.Component

@Component
class CustomFilter : Filter {
    override fun doFilter(
        serverRequest: ServletRequest?,
        serverletResponse: ServletResponse?,
        filterChain: FilterChain
    ) {
        println("Custom Filter is called")
        filterChain.doFilter(serverRequest, serverletResponse)
    }
}