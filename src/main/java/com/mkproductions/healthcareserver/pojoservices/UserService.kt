package com.mkproductions.healthcareserver.pojoservices

import com.mkproductions.healthcareserver.pojo.User
import org.springframework.stereotype.Component
import java.util.concurrent.CopyOnWriteArrayList
import java.util.function.Consumer

@Component
class UserService {
    private var userIDCount = 1
    private val userList: MutableList<User> = CopyOnWriteArrayList()

    fun addUser(user: User): User {
        user.userID = userIDCount
        userList.add(user)
        userIDCount++
        return user
    }

    fun userCount(): Int = userList.size


    val getUsers: List<User> = userList

    fun getUser(userID: Int): User {
        return userList.stream().filter { user: User -> user.userID == userID }.findFirst().get()
    }

    fun setUser(userID: Int, u: User): User {
        userList.forEach(Consumer { user: User ->
            if (user.userID == userID) {
                user.userID = userID
                user.userAge = u.userAge
                user.userName = u.userName
                user.userGender = u.userGender
            }
        })
        return userList.stream().filter { user: User -> user.userID == userID }.findFirst().get()
    }

    fun deleteUser(userID: Int) {
        userList.forEach(Consumer { user: User ->
            if (user.userID == userID) {
                userList.remove(user)
            }
        })
    }
}