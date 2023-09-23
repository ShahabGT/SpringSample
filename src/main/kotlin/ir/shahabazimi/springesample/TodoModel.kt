package ir.shahabazimi.springesample

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * @Author: Shahab Azimi
 * @Date: 2023 - 09 - 23
 **/
@Entity
data class TodoModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val date: String
)
