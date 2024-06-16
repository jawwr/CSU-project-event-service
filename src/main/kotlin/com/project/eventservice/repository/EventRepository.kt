package com.project.eventservice.repository

import com.project.eventservice.entities.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<Event, Long> {
}
