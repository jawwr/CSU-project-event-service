package com.project.eventservice.controllers

import com.project.eventservice.dto.EventRequest
import com.project.eventservice.service.EventService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
@Tag(name = "Event controller")
class EventController(private val service: EventService) {
    @GetMapping
    @Operation(summary = "Получение всех событий")
    fun getAllEvents() = ResponseEntity.ok(service.getEvents())

    @GetMapping("/{id}")
    @Operation(summary = "Получение события по id")
    fun getEventById(@PathVariable("id") id: Long) = ResponseEntity.ok(service.getEventById(id))

    @PostMapping
    @Operation(summary = "Создание события")
    fun createEvent(@RequestBody event: EventRequest) = ResponseEntity.ok(service.createEvent(event))

    @PutMapping("/{id}")
    @Operation(summary = "Обновить событие по id")
    fun updateEvent(
        @PathVariable("id") id: Long,
        @RequestBody event: EventRequest
    ) = ResponseEntity.ok(service.updateEvent(id, event))

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить событие по id")
    fun deleteEvent(@PathVariable("id") id: Long) = ResponseEntity.ok(service.deleteEvent(id))
}
