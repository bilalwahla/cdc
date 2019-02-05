package com.example.cdc.data

import com.example.cdc.event.PracticeCreatedEvent
import java.util.UUID

fun newDefaultPracticeCreatedEvent(block: PracticeCreatedEventBuilder.() -> Unit): PracticeCreatedEvent = PracticeCreatedEventBuilder().apply(block).build()

class PracticeCreatedEventBuilder {
    var id: UUID = UUID.randomUUID()

    fun build(): PracticeCreatedEvent = PracticeCreatedEvent(id)
}
