package com.example.four_software_design.api

import com.example.four_software_design.domain.Dataset
import com.example.four_software_design.service.fileWriter.FileWriter
import com.example.four_software_design.service.writerStrategy.Context
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject


@RestController
@RequestMapping("/dataset")
class DatasetController(
    private val restTemplate: RestTemplate? = null,
    private val context: Context,
    private val objectMapper: ObjectMapper,
    private val fileWriter: FileWriter
) {

    @GetMapping("/writer")
    @Throws(JsonProcessingException::class)
    fun writeData(): ResponseEntity<Unit> {
        objectMapper.registerModule(JavaTimeModule())
        return try {
            val datasetJson = restTemplate!!.getForObject<String>(
                "https://data.cityofnewyork.us/resource/hvrh-b6nb.json",
                Array<Dataset>::class.java
            )
            val datasets = objectMapper.readValue(datasetJson, Array<Dataset>::class.java)
            fileWriter.writeToFile(datasets)
            ResponseEntity.ok(context.writeDataset(datasets))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}