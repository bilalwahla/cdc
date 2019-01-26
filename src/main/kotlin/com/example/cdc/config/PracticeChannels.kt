package com.example.cdc.config

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface PracticeChannels {
    companion object {
        const val EVENT_TYPE_HEADER_NAME = "eventType"
    }

    @Output
    fun practiceSessionOutput(): MessageChannel
}
