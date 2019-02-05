package producer.practice.messaging

import org.springframework.cloud.contract.spec.Contract
import org.springframework.cloud.contract.spec.internal.DslProperty

import java.time.LocalDateTime

Contract.make {
    label 'practice_created_event'
    input {
        triggeredBy('process()')
    }
    outputMessage {
        sentTo(new DslProperty('practiceSessionInput', 'practiceSessionOutput'))
        body([
                id: $(producer(regex('[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}')), consumer(UUID.randomUUID().toString())),
                occurredOn: $(producer(regex('^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}$')), consumer(LocalDateTime.now().toString()))
        ])
        headers {
            header('eventType', 'PracticeCreatedEvent')
            messagingContentType(applicationJson())
        }
    }
}
