package ir.shahabazimi.springesample

import ir.shahabazimi.springesample.Extensions.DATE_REGEX
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @Author: Shahab Azimi
 * @Date: 2023 - 09 - 23
 **/
@RestController
class AppRestController(private val repository: TodoRepository) {

    @GetMapping("/todo")
    fun getList(): ResponseEntity<ApiResponse> {
        val data = repository.findAll()
        return ResponseEntity.status(200).body(
            ApiResponse(
                message = if (data.isEmpty()) "list is empty" else "success",
                response = data
            )
        )
    }


    @PostMapping("/todo")
    fun addItem(@RequestBody body: TodoCreateRequest): ResponseEntity<ApiResponse> = with(body) {

        return if (name.isNullOrBlank()) ResponseEntity.status(400).body(
            ApiResponse(
                message = "name cannot be empty",
                response = ""
            )
        )
        else if (date.isNullOrBlank() || !DATE_REGEX.matches(date))
            ResponseEntity.status(400).body(
                ApiResponse(
                    message = "date format is invalid use YYYY/MM/DD HH:MM format",
                    response = ""
                )
            )
        else {
            val response = repository.save(
                TodoModel(
                    name = name,
                    date = date
                )
            )
            ResponseEntity.status(201).body(
                ApiResponse(
                    message = "inserted",
                    response = response
                )
            )
        }

    }


    @DeleteMapping("/todo/{id}")
    fun removeItem(@PathVariable("id") id: Long): ResponseEntity<ApiResponse> {
        val data = repository.findById(id)
        return if (data.isEmpty) {
            ResponseEntity.status(400).body(
                ApiResponse(
                    message = "id not found",
                    response = ""
                )
            )

        } else {
            repository.delete(data.get())
            ResponseEntity.status(200).body(
                ApiResponse(
                    message = "removed",
                    response = ""
                )
            )
        }
    }

}