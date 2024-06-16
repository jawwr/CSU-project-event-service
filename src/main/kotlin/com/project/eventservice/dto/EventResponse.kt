package com.project.eventservice.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class EventResponse(
    val id: Long,
    val title: String,
    val text: String,
    val cityCode: String,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val dateStart: LocalDate,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val dateEnd: LocalDate
)
