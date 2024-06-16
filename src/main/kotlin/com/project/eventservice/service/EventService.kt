package com.project.eventservice.service

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
}
