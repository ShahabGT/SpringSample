package ir.shahabazimi.springesample

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @Author: Shahab Azimi
 * @Date: 2023 - 09 - 23
 **/
@Repository
interface TodoRepository : JpaRepository<TodoModel, Long>
