package com.example.four_software_design.service.writerStrategy

import com.example.four_software_design.domain.Dataset
import com.example.four_software_design.enums.WriteSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class Context(private val consoleWriter: ConsoleWriter, private val kafkaWriter: KafkaWriter) {
    @Value("\${data.sendTo}")
    lateinit var writeTo: String

    private val strategyMap: Map<WriteSource, WriterStrategy> = mapOf(
        WriteSource.CONSOLE to consoleWriter,
        WriteSource.KAFKA to kafkaWriter
    )

    fun writeDataset(datasetArray: Array<Dataset>) {
        val writerStrategy = strategyMap[WriteSource.valueOf(writeTo)]
        writerStrategy?.let { writerStrategy.write(datasetArray) }
            ?: throw Exception("No writer found")
    }

}