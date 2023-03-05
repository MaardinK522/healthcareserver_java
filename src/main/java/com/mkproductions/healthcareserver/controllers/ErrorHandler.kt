package com.mkproductions.healthcareserver.controllers

import com.mkproductions.healthcareserver.exceptions.CustomError
import com.mkproductions.healthcareserver.exceptions.UserNotFoundException
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
class ErrorHandler : ResponseEntityExceptionHandler() {
    @Value("\${server_doc_address}")
    private lateinit var details: String

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(
        userNotFoundException: UserNotFoundException, webRequest: WebRequest
    ): ResponseEntity<CustomError> {
        return ResponseEntity(CustomError(-1, userNotFoundException.message!!, details), HttpStatus.NOT_FOUND)
    }
}