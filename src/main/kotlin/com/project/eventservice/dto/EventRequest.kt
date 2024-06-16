package com.project.eventservice.dto

import java.time.LocalDate

data class EventRequest(
    val title: String,
    val text: String,
    val cityCode: String,
    val dateStart: LocalDate,
    val dateEnd: LocalDate
)