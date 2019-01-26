package com.example.cdc.event.publisher

import com.example.cdc.config.PracticeChannels
import com.example.cdc.config.PracticeChannels.Companion.EVENT_TYPE_HEADER_NAME
import com.example.cdc.event.DomainEvent
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class PracticePublisher(private val practiceChannels: PracticeChannels) {
    fun publish(event: DomainEvent) {
        practiceChannels
                .practiceSessionOutput()
                .send(MessageBuilder.withPayload(event).setHeader(EVENT_TYPE_HEADER_NAME, event::class.java.simpleName).build())
    }
}
