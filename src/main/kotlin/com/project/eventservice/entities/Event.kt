package com.project.eventservice.entities

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "events")
data class Event(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "numeric")
    var id: Long,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "text", nullable = false)
    var text: String,

    @Column(name = "city_code", nullable = false)
    var cityCode: String,

    @Column(name = "date_start", nullable = false)
    var dateStart: LocalDate,

    @Column(name = "date_end", nullable = false)
    var dateEnd: LocalDate,

    @Column(name = "date_create", nullable = false)
    var dateCreate: LocalDateTime?,

    @Column(name = "date_modify", nullable = false)
    var dateModify: LocalDateTime?
) {
    @PrePersist
    private fun prePersist() {
        val now = LocalDateTime.now()
        dateCreate = now
        dateModify = now
    }

    @PreUpdate
    private fun preUpdate() {
        dateModify = LocalDateTime.now()
    }
}
