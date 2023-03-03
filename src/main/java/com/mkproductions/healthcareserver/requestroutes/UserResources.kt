package com.mkproductions.healthcareserver.requestroutes

import com.mkproductions.healthcareserver.pojo.User
import com.mkproductions.healthcareserver.pojoservices.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/users"])
class UserResources {
    @Autowired
    lateinit var userService: UserService

    @PostMapping
    fun addUser(@RequestBody user: User): User {
        return userService.addUser(user)
    }

    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.getUsers
    }

    @GetMapping(value = ["/{userID}"])
    fun getUser(@PathVariable("userID") userID: Int): User {
        return userService.getUser(userID)
    }

    @PutMapping(value = ["/{userID}"])
    fun updateUser(@PathVariable("userID") userID: Int, @RequestBody user: User): User {
        userService.setUser(userID, user)
        return user
    }

    @DeleteMapping(value = ["{userID}"])
    fun deleteUser(@PathVariable("userID") userID: Int) {
        userService.deleteUser(userID)
    }
}
