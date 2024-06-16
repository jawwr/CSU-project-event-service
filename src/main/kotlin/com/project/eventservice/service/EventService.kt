package com.project.eventservice.service

import com.project.eventservice.dto.EventRequest
import com.project.eventservice.dto.EventResponse
import com.project.eventservice.entities.Event
import com.project.eventservice.mapping.EventMapper
import com.project.eventservice.repository.EventRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

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

    @Transactional
    fun createEvent(eventRequest: EventRequest): EventResponse {
        val event = mapper.fromEventRequest(eventRequest)
        validateEvent(event)
        val savedEvent = repository.save(event)
        return mapper.toEventResponse(savedEvent)
    }

    @Transactional
    fun updateEvent(id: Long, eventRequest: EventRequest): EventResponse {
        val event = mapper.fromEventRequest(eventRequest).apply { this.id = id }
        validateEvent(event)
        val savedEvent = repository.findById(id)
            .orElseThrow { throw Exception("Event with id $id doesn't exist") }
        updateEvent(event, savedEvent)
        val updatedEvent = repository.save(savedEvent)
        return mapper.toEventResponse(updatedEvent)
    }

    @Transactional
    fun deleteEvent(id: Long) = repository.deleteById(id)

    fun updateEvent(updateEvent: Event, savedEvent: Event) = savedEvent.apply {
        this.title = updateEvent.title
        this.cityCode = updateEvent.cityCode
        this.text = updateEvent.text
        this.dateEnd = updateEvent.dateEnd
        this.dateStart = updateEvent.dateStart
    }

    private fun validateEvent(event: Event) {
        if (event.dateEnd.isBefore(event.dateStart)) {
            throw Exception("Date start must be before date create")
        }
        if (LocalDate.now().isAfter(event.dateEnd)) {
            throw Exception("Date end must be after now")
        }
    }
}
