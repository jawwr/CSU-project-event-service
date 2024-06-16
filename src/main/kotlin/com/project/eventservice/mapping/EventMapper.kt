package com.project.eventservice.mapping

import com.project.eventservice.dto.EventRequest
import com.project.eventservice.dto.EventResponse
import com.project.eventservice.entities.Event
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface EventMapper {
    fun toEventResponse(event: Event): EventResponse
    fun fromEventRequest(eventRequest: EventRequest): Event
}
