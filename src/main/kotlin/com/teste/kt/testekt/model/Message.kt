package com.teste.kt.testekt.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Message(
    @Id
    @GeneratedValue
    val id: String,
    val message: String
    ) {


}