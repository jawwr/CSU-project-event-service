package com.project.eventservice.controllers

import com.project.eventservice.service.EventService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/events")
@Tag(name = "Event controller")
class EventController(private val service: EventService) {
    @GetMapping
    @Operation(summary = "Получение всех событий")
    fun getAllEvents() = ResponseEntity.ok(service.getEvents())
}
