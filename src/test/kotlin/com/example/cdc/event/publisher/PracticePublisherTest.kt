package com.example.cdc.event.publisher

import com.example.cdc.config.PracticeChannels
import com.example.cdc.data.newDefaultPracticeCreatedEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.Message
import org.springframework.test.context.junit4.SpringRunner
import java.util.concurrent.BlockingQueue

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PracticePublisherTest {
    companion object {
        const val EVENT_TYPE_HEADER_NAME = "eventType"
    }

    @Autowired
    lateinit var messageController: MessageCollector

    @Autowired
    lateinit var practicePublisher: PracticePublisher

    @Autowired
    lateinit var practiceChannels: PracticeChannels

    @Autowired
    lateinit var mapper: ObjectMapper

    @Test
    fun `should be able to publish practice event`() {
        val event = newDefaultPracticeCreatedEvent { }

        practicePublisher.publish(event)

        verifyPublication(messageController.forChannel(practiceChannels.practiceSessionOutput()), event, event::class.java.simpleName)
    }

    private fun <T> verifyPublication(queue: BlockingQueue<Message<*>>, event: T, type: String) {
        val message = queue.take()
        assertEquals(message.headers[EVENT_TYPE_HEADER_NAME], type)
        assertEquals(message.payload, mapper.writeValueAsString(event))
    }
}
