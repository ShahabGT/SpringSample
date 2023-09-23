package ir.shahabazimi.springesample

import jakarta.validation.constraints.NotBlank

/**
 * @Author: Shahab Azimi
 * @Date: 2023 - 09 - 23
 **/
data class TodoCreateRequest(
    @NotBlank val name: String?,
    @NotBlank val date: String?
)
