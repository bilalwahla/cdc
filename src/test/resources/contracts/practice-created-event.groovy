import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label 'practice_created_event'
    input {
        triggeredBy('process()')
    }
    outputMessage {
        sentTo('practiceSessionOutput')
        body([
                id: $(producer(regex('[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}'))),
                occuredOn: $(producer(regex('^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}:\\d{3}$')))
        ])
        headers {
            header('eventType', 'PracticeCreatedEvent')
            messagingContentType(applicationJson())
        }
    }
}
