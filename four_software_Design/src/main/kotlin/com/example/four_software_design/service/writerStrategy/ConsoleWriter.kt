package com.example.four_software_design.service.writerStrategy

import com.example.four_software_design.domain.Dataset
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ConsoleWriter: WriterStrategy() {
    private val logger: Logger = LoggerFactory.getLogger(javaClass.simpleName)

    override fun write(datasetArray: Array<Dataset>) {
        datasetArray.forEach { logger.info(it.toString()) }
    }
}