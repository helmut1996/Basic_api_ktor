package com.example.models
import kotlinx.serialization.*

@Serializable
data class Customer(val id: Int, val firstName: String, val lastName: String)
