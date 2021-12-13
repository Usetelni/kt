package model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Message(
    @Id
    @GeneratedValue
    val id: String,
    val message: String
    ) {


}