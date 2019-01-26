package com.example.cdc.event

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.UUID

abstract class DomainEvent(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ss.SSS") val occurredOn: LocalDateTime = LocalDateTime.now()
)

data class PracticeCreatedEvent(val id: UUID = UUID.randomUUID()) : DomainEvent()