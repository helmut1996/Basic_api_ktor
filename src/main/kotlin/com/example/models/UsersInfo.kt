package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class UsersInfo(val firstname:String, val lastname:String, val email:String, val numbers:Int)
