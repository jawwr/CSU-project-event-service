package com.project.eventservice.controllers.handler

import com.project.eventservice.dto.ExceptionMessage
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e: Exception) = ResponseEntity.badRequest()
        .body(ExceptionMessage(requireNotNull(e.message)))
}
