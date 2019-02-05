package com.example.cdc

import com.example.cdc.config.PracticeChannels
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

@SpringBootApplication
@EnableBinding(PracticeChannels::class)
class CdcApplication

fun main(args: Array<String>) {
	runApplication<CdcApplication>(*args)
}

