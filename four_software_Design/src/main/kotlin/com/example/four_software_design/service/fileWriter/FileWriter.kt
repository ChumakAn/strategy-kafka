package com.example.four_software_design.service.fileWriter

import com.example.four_software_design.domain.Dataset
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.stereotype.Component
import java.io.File

@Component
class FileWriter(private val objectMapper: ObjectMapper) {
    companion object {
        const val path = "src/main/resources/dataset.json"
    }
    fun writeToFile(datasetArray: Array<Dataset>) {
        objectMapper.registerModule(JavaTimeModule())
        objectMapper.writeValue(File(path), datasetArray)
    }
}