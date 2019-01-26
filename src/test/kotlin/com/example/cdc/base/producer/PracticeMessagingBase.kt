package com.example.cdc.base.producer

import com.example.cdc.event.DomainEvent
import com.example.cdc.service.PracticeService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
abstract class PracticeMessagingBase {
    @Inject
    lateinit var messaging: MessageVerifier<DomainEvent>

    @Autowired
    lateinit var practiceService: PracticeService

    @BeforeEach
    fun setup() {
        this.messaging.receive("practiceSessionOutput", 100, TimeUnit.MILLISECONDS)
    }

    fun process() {
        practiceService.process()
    }
}
