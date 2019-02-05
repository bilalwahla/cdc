package com.example.cdc.message.producer

import com.example.cdc.service.PracticeService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
abstract class PracticeMessagingBase {
    @Autowired
    lateinit var practiceService: PracticeService

    fun process() {
        practiceService.process()
    }
}
