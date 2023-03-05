package com.mkproductions.healthcareserver.configurations

import com.mkproductions.healthcareserver.filters.CustomFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class FilterConfiguration {
    @Bean
    open fun registerBean(): FilterRegistrationBean<CustomFilter> {
        val registrationBean = FilterRegistrationBean<CustomFilter>()
        registrationBean.filter = CustomFilter()
        registrationBean.addUrlPatterns("/users/*")
        return registrationBean
    }
}