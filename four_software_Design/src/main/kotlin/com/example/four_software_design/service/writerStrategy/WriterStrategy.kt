package com.example.four_software_design.service.writerStrategy

import com.example.four_software_design.domain.Dataset

abstract class WriterStrategy {
    abstract fun write(datasetArray: Array<Dataset>)
}

