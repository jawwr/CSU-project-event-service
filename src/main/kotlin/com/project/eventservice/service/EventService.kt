package com.project.eventservice.service

import com.project.eventservice.dto.EventResponse
import com.project.eventservice.mapping.EventMapper
import com.project.eventservice.repository.EventRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EventService(
    private val mapper: EventMapper,
    private val repository: EventRepository
) {
    @Transactional(readOnly = true)
    fun getEvents() = repository.findAll().map { mapper.toEventResponse(it) }

    @Transactional(readOnly = true)
    fun getEventById(id: Long): EventResponse =
        repository.findById(id)
            .orElseThrow { Exception("Event with id $id doesn't exist") }
            .let { mapper.toEventResponse(it) }
}
