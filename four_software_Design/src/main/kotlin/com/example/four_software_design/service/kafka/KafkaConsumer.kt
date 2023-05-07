package com.example.four_software_design.service.kafka

import com.example.four_software_design.constants.AppConstants
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {
    @KafkaListener(topics = [AppConstants.TOPIC_NAME])
    fun listen(msg: String) {
        println("Message Received - $msg")
    }
}