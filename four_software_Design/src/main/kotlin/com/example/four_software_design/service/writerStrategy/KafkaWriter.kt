package com.example.four_software_design.service.writerStrategy

import com.example.four_software_design.domain.Dataset
import com.example.four_software_design.service.kafka.KafkaProducer
import org.springframework.stereotype.Component

@Component
class KafkaWriter(private val kafkaProducer: KafkaProducer): WriterStrategy() {
    override fun write(datasetArray: Array<Dataset>) {
        datasetArray.forEach { kafkaProducer.sendEvent(it.toString()) }
    }
}