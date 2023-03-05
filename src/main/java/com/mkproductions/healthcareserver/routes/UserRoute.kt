package com.mkproductions.healthcareserver.routes

import com.mkproductions.healthcareserver.pojos.User
import com.mkproductions.healthcareserver.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/users"])
class UserRoute {
    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun addUser(@RequestBody user: User): ResponseEntity<User> {
        val newUser = userService.addUser(user)
        println(newUser)
        return ok(newUser)
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ok(userService.getUsers())
    }

    @GetMapping(value = ["/{userID}"])
    fun getUser(@PathVariable("userID") userID: Int): ResponseEntity<User> {
        val user = userService.getUser(userID)
        println(user)
        return ok(user)
    }

    @PutMapping(value = ["/{userID}"])
    fun updateUser(@PathVariable("userID") userID: Int, @RequestBody user: User): ResponseEntity<User> {
        val updatedUser = userService.setUser(userID, user)
        return ok(updatedUser)
    }

    @DeleteMapping(value = ["{userID}"])
    fun deleteUser(@PathVariable("userID") userID: Int): ResponseEntity<Unit> {
        return ok(userService.deleteUser(userID))
    }
}
