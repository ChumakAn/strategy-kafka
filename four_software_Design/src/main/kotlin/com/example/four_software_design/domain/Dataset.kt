package com.example.four_software_design.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Dataset(
    @JsonProperty("vendorid")
    val vendorId: Int,
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    @JsonProperty("lpep_pickup_datetime")
    val pickupDatetime: LocalDateTime?,
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    @JsonProperty("lpep_dropoff_datetime")
    val dropOffDatetime: LocalDateTime?,
    @JsonProperty("store_and_fwd_flag")
    val storeAndFwdFlag: String?,
    @JsonProperty("ratecodeid")
    val rateCodeId: Int?,
    @JsonProperty("pickup_longitude")
    val pickupLongitude: Double?,
    @JsonProperty("pickup_latitude")
    val pickupLatitude: Double?,
    @JsonProperty("dropoff_longitude")
    val dropOffLongitude: Double?,
    @JsonProperty("dropoff_latitude")
    val dropOffLatitude: Double?,
    @JsonProperty("passenger_count")
    val passengerCount: Int?,
    @JsonProperty("trip_distance")
    val tripDistance: Double?,
    @JsonProperty("fare_amount")
    val fareAmount: Double?,
    @JsonProperty("extra")
    val extra: Double?,
    @JsonProperty("mta_tax")
    val mtaTax: Double?,
    @JsonProperty("tip_amount")
    val tipAmount: Double?,
    @JsonProperty("tolls_amount")
    val tollsAmount: Double?,
    @JsonProperty("improvement_surcharge")
    val improvementSurcharge: Double?,
    @JsonProperty("total_amount")
    val totalAmount: Double?,
    @JsonProperty("payment_type")
    val paymentType: Int?,
    @JsonProperty("trip_type")
    val tripType: Int?
)
