package com.example.cdc.service

import com.example.cdc.event.PracticeCreatedEvent
import com.example.cdc.event.publisher.PracticePublisher
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PracticeService(private val practicePublisher: PracticePublisher) {
    companion object {
        private val log = LoggerFactory.getLogger(PracticeService::class.java)
    }

    fun process() {
        log.info("Publishing event")
        practicePublisher.publish(PracticeCreatedEvent())
    }
}