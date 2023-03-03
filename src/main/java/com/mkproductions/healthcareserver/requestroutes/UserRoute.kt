package com.mkproductions.healthcareserver.requestroutes

import com.mkproductions.healthcareserver.pojo.User
import com.mkproductions.healthcareserver.pojoservices.UserService
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
    fun getAllUsers(): ResponseEntity<ArrayList<User>> {
        return ok(userService.getUsers())
    }

    @GetMapping(value = ["/{userID}"])
    fun getUser(@PathVariable("userID") userID: Int): ResponseEntity<Optional<User>> {
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
    fun deleteUser(@PathVariable("userID") userID: Int): ResponseEntity<Int> {
        return ok(userService.deleteUser(userID))
    }
}
